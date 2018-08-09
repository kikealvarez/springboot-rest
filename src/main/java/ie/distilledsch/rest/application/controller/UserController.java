package ie.distilledsch.rest.application.controller;

import ie.distilledsch.rest.domain.entity.User;
import ie.distilledsch.rest.domain.exception.UserNotFoundException;
import ie.distilledsch.rest.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity listUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable String id) {
        Optional<User> user = userService.getUser(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        User userCreated = userService.createUser(user);

        return ResponseEntity.ok(userCreated);
    }

    @PutMapping("/user")
    public ResponseEntity replaceUser(@Valid @RequestBody User user, BindingResult result) throws UserNotFoundException {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        try {
            userService.editUser(user);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) throws UserNotFoundException {
        try {
            userService.deleteUser(id);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

}
