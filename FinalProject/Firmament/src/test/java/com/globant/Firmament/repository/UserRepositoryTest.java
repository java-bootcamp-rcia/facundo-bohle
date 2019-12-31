package com.globant.Firmament.repository;

import com.globant.Firmament.user.model.User;
import com.globant.Firmament.user.repository.UserRepository;
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
    public void canFindUserByUsername() {
        User savedUser= entityManager.persistFlushFind(new User("bohledevs2","mypass321", "facubohle2@gmail.com"));
        User user= userRepository.findByUsername("bohledevs2");
        assertEquals(savedUser.getUsername(), user.getUsername());
    }

}
