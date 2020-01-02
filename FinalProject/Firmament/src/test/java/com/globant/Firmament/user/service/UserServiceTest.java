package com.globant.Firmament.user.service;

import com.globant.Firmament.user.exception.InputException;
import com.globant.Firmament.user.exception.UserNotFoundException;
import com.globant.Firmament.user.model.User;
import com.globant.Firmament.user.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private UserService userService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp(){
        userService= new UserService(userRepository);
    }

    // Register

    @Test
    public void whenPostSaveUser_thenReturnSaved() {
        given(userRepository.save(any())).willReturn(new User("bohledevs3","asd","asda"));

        User savedUser = userService.saveUser("bohledevs3","mypass321","mypass321","none");

        assertEquals(savedUser.getUsername(),"bohledevs3");
    }

    @Test(expected = InputException.class)
    public void givenPasswordsMismatch_whenPost_thenReturnError() throws InputException{

      userService.saveUser("bohledevs3", "mypass321", "mypass", "none");
    }

    @Test
    public void givenNullParameters_whenPost_thenReturnError() {
        given(userRepository.save(any())).willReturn(null);

        userService.saveUser("bohledevs","","","none");
    }

    @Test(expected = InputException.class)
    public void givenUserAlreadyExists_whenPost_thenReturnError() throws InputException {
        User user= new User("bohledevs","m1","none");

        given(userRepository.findByUsername(anyString())).willReturn(user);
        given(userRepository.findByEmail(anyString())).willReturn(user);

        userService.saveUser("bohledevs","mypass1","mypass1","anotheremail@gmail.com");
    }


    // Log In

    @Test(expected = InputException.class)
    public void givenBlankParams_whenLogIn_thenReturnError() {

        userService.logIn("","");
    }

    @Test(expected = UserNotFoundException.class)
    public void givenWrongUser_whenLogIn_thenReturnError() {
        given(userRepository.findByUsername(anyString())).willReturn(null);

        userService.logIn("nonexistent","321");
    }

    @Test(expected = InputException.class)
    public void givenWrongPassword_whenLogIn_thenReturnError() {
        given(userRepository.findByUsername(anyString())).willReturn(new User("bohledevs100","pass321","none"));

        userService.logIn("bohledevs100","mypass123");
    }

    @Test
    public void givenCorrectData_whenLogIn_thenReturnSuccessMessage() {
        given(userRepository.findByUsername(anyString())).willReturn(new User("bohledevs100","pass321","none"));

        String result = userService.logIn("bohledevs100","pass321");

        assertEquals(result,"Logged In Successfully");
    }

    @Test
    public void givenCorrectData_whenLogin_thenUpdateStatus() {

        User user= new User("bohledevs99","pass123","none");
        user.setStatus(false);

        given(userRepository.findByUsername(any())).willReturn(user);
        given(userRepository.save(any())).willReturn(user);

        userService.logIn("bohledevs99","pass123");

        assertTrue(user.getStatus());
    }

    // Log Out

    @Test
    public void canLogOut() {
        User user = new User("bohledevs2","non","non");

        given(userRepository.findByUsername(anyString())).willReturn(user);
        given(userRepository.save(any())).willReturn(user);

        String result = userService.logOut("bohledevs2");

        assertFalse(user.getStatus());
        assertEquals(result, "Successfully Logged Out");
    }

    @Test(expected = InputException.class)
    public void givenUserIsAlreadyLoggedOut_whenLogOut_thenReturnError() {
        User user = new User("bohledevs2","non","non");

        given(userRepository.findByUsername(anyString())).willReturn(user);
        given(userRepository.save(any())).willReturn(user);

        userService.logOut("bohledevs2");
        userService.logOut("bohledevs2");
    }

    @Test(expected = UserNotFoundException.class)
    public void givenUserNotFound_whenLogOut_thenReturnError() {
        given(userRepository.findByUsername(anyString())).willReturn(null);

        userService.logOut("asdsa1");
    }
}
