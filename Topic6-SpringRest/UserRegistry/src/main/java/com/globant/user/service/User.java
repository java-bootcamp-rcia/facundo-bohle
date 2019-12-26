package com.globant.user.service;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {
    private @Id @GeneratedValue Long id;
    private String username;
    private String nickname;
    private String password;
    private String email;

    protected User() {}

    public User(String username, String nickname, String password, String email) {
        this.username= username;
        this.nickname=nickname;
        this.password=password;
        this.email=email;
    }
}
