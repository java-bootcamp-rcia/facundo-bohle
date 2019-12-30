package com.globant.Firmament.user.controller;

import com.globant.Firmament.user.exception.InputException;
import com.globant.Firmament.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public String addUser(@RequestParam(required=true) String username,
                         @RequestParam(required=true) String password,
                         @RequestParam(required=true) String confirmPassword,
                         @RequestParam(required=false) String email) throws InputException {

        return userService.save(username,password,confirmPassword,email);

    }

}
