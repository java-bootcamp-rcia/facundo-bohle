package com.globant.user;

import com.globant.user.controller.UserController;
import com.globant.user.exceptions.UserDuplicateException;
import com.globant.user.exceptions.UserNotFoundException;
import com.globant.user.service.User;
import com.globant.user.service.UserService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void GetUser_shouldReturnUser() throws Exception {

        given(userService.getUserDetails(anyString())).willReturn(new User("bohledevs","facuXx2020","mypass321","facubohle2@gmail.com"));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/bohledevs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("username").value("bohledevs"))
                .andExpect(jsonPath("nickname").value("facuXx2020"));
    }

    @Test
    public void givenUserDoesNotExist_whenGet_thenReturnNotFound() throws Exception {
        given(userService.getUserDetails(anyString())).willThrow(new UserNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/users/bohledevSSs"))
               .andExpect(status().isNotFound());
    }

    @Test
    public void givenUserExists_whenPost_thenRetunEx() throws Exception {
        given(userService.saveUser(any())).willThrow(new UserDuplicateException());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void canPost_newUser() throws Exception {
        User user= new User("","","","");
        given(userService.saveUser(any())).willReturn(user);

        Gson gson= new Gson();
        mockMvc.perform(MockMvcRequestBuilders.post("/users/")
        .content(gson.toJson(user))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        );

    }




}
