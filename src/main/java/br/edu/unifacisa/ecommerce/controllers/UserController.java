package br.edu.unifacisa.ecommerce.controllers;
import br.edu.unifacisa.ecommerce.entities.User;
import br.edu.unifacisa.ecommerce.exceptions.UserAlreadyExistsException;
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

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatus.OK);
    };

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
    public ResponseEntity<User> editUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.editUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("O usuário foi deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
        return new ResponseEntity<User>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<String> getBalance(@PathVariable("id") int id) {
        return ResponseEntity.ok("Your balance: " + userService.getBalance(id));
    }

    public ResponseEntity<String> getAddress(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.getAddress(id));
    }

    @GetMapping("/status")
    public String checkStatus() {
        return "Online";
    }
}
