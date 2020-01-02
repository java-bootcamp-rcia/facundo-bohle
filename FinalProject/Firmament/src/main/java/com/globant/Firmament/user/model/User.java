package com.globant.Firmament.user.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="auth_user")
public class User {

    @Column(name="auth_user_id")
    private @Id @GeneratedValue Long id;
    private String username;
    private String password;
    private String email;
    private boolean status;
    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
    private Set<Role> roles;*/

    protected User() {}

    public User (String username, String password, String email) {
        this.username=username;
        this.password=password;
        this.email=email;
        this.status= true;
    }

    public boolean getStatus() {
        return status;
    }
}
