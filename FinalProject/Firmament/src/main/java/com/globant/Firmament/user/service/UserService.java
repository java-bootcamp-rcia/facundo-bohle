package com.globant.Firmament.user.service;

import com.globant.Firmament.user.exception.InputException;
import com.globant.Firmament.user.model.User;
import com.globant.Firmament.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(){};

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String save(String username, String password, String confirmPassword, String email) throws InputException {
        User user= new User(username,password,email);
        userRepository.save(user);
        return ("Sucessfully Saved user" + username);
    }
}
