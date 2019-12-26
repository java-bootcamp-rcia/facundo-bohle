package com.globant.user.controller;

import com.globant.user.service.User;
import com.globant.user.service.UserService;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}")
    private User getUserByUsername(@PathVariable String username) {
        return userService.getUserDetails(username);
    }

    @GetMapping("/users/")
    private Iterable<User> getUsersByNickname(@RequestParam String nickname) {
        return userService.getUsersByNickname(nickname);
    }

    @PostMapping("/users/")
    private User newUser(@RequestParam String jsonString) {
        return userService.saveUser(fromJsonToUser(jsonString));
    }

    @PutMapping("/users/{username}")
    private User updateUser(@RequestParam String jsonString) {
        return userService.saveUser(fromJsonToUser(jsonString));
    }

    @DeleteMapping("/users/username}")
    public ResponseEntity<User> deletePost(@PathVariable String username) {

        boolean isRemoved = userService.deleteUser(username);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private User fromJsonToUser(String jsonString) {
        Gson gson= new Gson();
        return gson.fromJson(jsonString,User.class);
    }
}
