package com.globant.user;

import com.globant.user.repository.UserRepository;
import com.globant.user.service.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getUser_returnsUserDetails() throws Exception {

        User savedUser= entityManager.persistFlushFind(new User("bohledevs","facuXx2020","mypass321", "facubohle2@gmail.com"));
        User user= userRepository.findByUsername("bohledevs");

        assertEquals(savedUser.getUsername(), user.getUsername());
        assertEquals(savedUser.getNickname(),user.getNickname());
    }


}