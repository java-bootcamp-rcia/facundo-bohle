package com.globant.Firmament.user.controller;

import com.globant.Firmament.user.exception.InputException;
import com.globant.Firmament.user.model.User;
import com.globant.Firmament.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public User addUser(@RequestParam(required=true) String username,
                        @RequestParam(required=true) String password,
                        @RequestParam(required=true) String confirmPassword,
                        @RequestParam(required=false) String email) throws InputException {

       return userService.saveUser(username,password,confirmPassword,email);

    }

    @GetMapping("/login")
    public String logIn( @RequestParam(required = true) String username,
                         @RequestParam(required = true) String password) throws InputException {

        return userService.logIn(username,password);

    }

    @GetMapping("logout")
    public String logOut(@RequestParam(required = true) String username) throws InputException {

        return userService.logOut(username);
    }


}
