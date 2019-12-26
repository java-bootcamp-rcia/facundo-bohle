package com.globant.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDuplicateException extends RuntimeException {
    public UserDuplicateException() {
        super("Username already exists.");
    }
}
