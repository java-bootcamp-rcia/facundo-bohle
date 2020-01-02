package com.globant.Firmament.user.service;

import com.globant.Firmament.user.exception.InputException;
import com.globant.Firmament.user.exception.UserNotFoundException;
import com.globant.Firmament.user.model.User;
import com.globant.Firmament.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;

import static java.util.Objects.isNull;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    protected UserService(){};

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(String username, @NotBlank String password, @NotBlank String confirmPassword, String email) throws InputException {

        if (!(password.equals(confirmPassword)))
            throw new InputException("Passwords are not the same.");

        if (userRepository.findByUsername(username)!=null)
            throw new InputException("User already exists");

        if (userRepository.findByEmail(email)!=null)
            throw new InputException("User already registered with that email");

        if (isNull(email))
            email= "none";

        User savedUser=  userRepository.save(new User(username,password,email));

        return savedUser;
    }

    public String logIn(String username, String password) {
        if (username.length() == 0 || password.length()==0)
            throw new InputException("Blank params are not accepted.");

        User user= userRepository.findByUsername(username);

        if (user==null)
            throw new UserNotFoundException();

        if (!user.getPassword().equals(password))
            throw new InputException("Wrong Password");

        user.setStatus(true);
        userRepository.save(user);

        return "Logged In Successfully";
    }

    public String logOut(String username) {

        User user= userRepository.findByUsername(username);

        if (isNull(user))
            throw new UserNotFoundException();

        if (!user.getStatus())
            throw new InputException("User is already logged out.");

        user.setStatus(false);
        userRepository.save(user);

        return "Successfully Logged Out";
    }
}
