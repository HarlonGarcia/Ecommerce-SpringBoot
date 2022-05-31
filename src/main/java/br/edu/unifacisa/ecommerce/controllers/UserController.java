package br.edu.unifacisa.ecommerce.controllers;

import br.edu.unifacisa.ecommerce.dto.UserDto;
import br.edu.unifacisa.ecommerce.entities.Cart;
import br.edu.unifacisa.ecommerce.entities.User;
import br.edu.unifacisa.ecommerce.exceptions.UserAlreadyExistsException;
import br.edu.unifacisa.ecommerce.exceptions.ContentNotFoundException;
import br.edu.unifacisa.ecommerce.services.CartService;
import br.edu.unifacisa.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            return new ResponseEntity<>(userService.login(username, password), HttpStatus.OK);
        } catch (ContentNotFoundException | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("User " + user.getUsername() + " was created!", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> editUser(@RequestBody User user) {
        try {
            UserDto userDto = userService.editUser(user).toDto();
            return new ResponseEntity<String>("User updated successfully!", HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }

    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable("username") String username) {
        try {
            userService.deleteUser(username);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("User was deleted!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable("username") String username) {
        try {
            User user = userService.findByUsername(username);
            UserDto userDto = user.toDto();
            return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cart")
    public ResponseEntity<String> addToCart(@RequestParam("product_id") String product_id, @RequestParam("username") String username) {
        try {
            cartService.addProductToCart(product_id, username);
            return new ResponseEntity<String>("Product added successfully!", HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cart-details")
    public ResponseEntity<Cart> findCart(@RequestParam("username") String username) {
        try {
            return new ResponseEntity<>(cartService.findCartByUsername(username), HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

