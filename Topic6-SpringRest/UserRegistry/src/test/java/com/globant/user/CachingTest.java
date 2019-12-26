package com.globant.user;

import com.globant.user.repository.UserRepository;
import com.globant.user.service.User;
import com.globant.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase

public class CachingTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void GetUser_returnsCachedUser_callsRepositoryOnlyOnce() {
        given(userRepository.findByUsername(anyString())).willReturn(new User("bohledevs","facuXx2020","mypass321","facubohle2@gmail.com"));

        userService.getUserDetails("bohledevs");
        userService.getUserDetails("bohledevs");

        verify(userRepository,times(1)).findByUsername("bohledevs");

    }
}
