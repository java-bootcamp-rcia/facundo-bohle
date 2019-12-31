package com.globant.Firmament.user.repository;

import com.globant.Firmament.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    public User findByEmail(String email);
}
