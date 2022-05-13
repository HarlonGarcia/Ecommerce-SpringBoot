package br.edu.unifacisa.ecommerce.controllers;
import br.edu.unifacisa.ecommerce.entities.User;
import br.edu.unifacisa.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatus.OK);
    };

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> editUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.editUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("O usuário foi deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<User>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/status")
    public String checkStatus() {
        return "Online";
    }
}
