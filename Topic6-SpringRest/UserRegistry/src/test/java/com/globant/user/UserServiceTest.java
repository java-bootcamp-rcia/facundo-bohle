package com.globant.user;

import com.globant.user.exceptions.UserNotFoundException;
import com.globant.user.repository.UserRepository;
import com.globant.user.service.User;
import com.globant.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private UserService userService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception{
        userService= new UserService(userRepository);
    }

    @Test
    public void getUserDetails_returnsUserInfo() {
        given(userRepository.findByUsername(anyString())).willReturn(new User("bohledevs","facuXx2020","mypass321","facubohle2@gmail.com"));

        User user= userService.getUserDetails("bohledevs");

        assertTrue("bohledevs".equals(user.getUsername()));
        assertTrue("facuXx2020".equals(user.getNickname()));
        assertTrue("facubohle2@gmail.com".equals(user.getEmail()));

    }

    @Test(expected = UserNotFoundException.class)
    public void givenUserDoesNotExist_whenGetUser_thenReturnEx() throws UserNotFoundException {
        given(userRepository.findByUsername("bohledevs")).willReturn(null);
        userService.getUserDetails("bohledevs");
    }
}
