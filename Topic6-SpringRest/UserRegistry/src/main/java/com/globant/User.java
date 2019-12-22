package com.globant;

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

    protected User() {}

    public User(String username, String nickname, String password) {
        this.username= username;
        this.nickname=nickname;
        this.password=password;
    }
}
