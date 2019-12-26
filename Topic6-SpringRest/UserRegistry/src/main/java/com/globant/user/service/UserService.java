package com.globant.user.service;

import com.globant.user.exceptions.UserDuplicateException;
import com.globant.user.exceptions.UserNotFoundException;
import com.globant.user.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable("users")
    public User getUserDetails(String username) {
        User user= userRepository.findByUsername(username);

        if (user==null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    public Iterable<User> getUsersByNickname(String nickname){
        Iterable<User> users= userRepository.findAllByNickname(nickname);
        if (users==null)
            throw new UserNotFoundException();
        return users;
    }

    public User saveUser(User user) {
        if (userRepository.findByUsername(user.getUsername())!=null) {
            throw new UserDuplicateException();
        }
        return userRepository.save(user);
    }

    public boolean deleteUser(String username) {
        User user= userRepository.findByUsername(username);
        if (user==null)
            return false;
        userRepository.delete(user);
        return true;
    }
}
