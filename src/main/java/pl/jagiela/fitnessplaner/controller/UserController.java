package pl.jagiela.fitnessplaner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jagiela.fitnessplaner.entity.User;
import pl.jagiela.fitnessplaner.model.RegisterUserRequest;
import pl.jagiela.fitnessplaner.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> addNewUser(@RequestBody RegisterUserRequest registerUserRequest) {
        User user = userService.addNewUser(registerUserRequest);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/userName/{userName}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @GetMapping("/validateUserName/{userName}")
    public ResponseEntity<String> validateUserName(@PathVariable String userName) {
        String validators = userService.validateUserName(userName);
        return ResponseEntity.status(HttpStatus.OK).body(validators);
    }

}
