package com.globant.user.repository;

import com.globant.user.service.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    Iterable<User> findAllByNickname(String nickname);
}
