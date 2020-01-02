package com.globant.Firmament.user.controller;


import com.globant.Firmament.user.model.User;
import com.globant.Firmament.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest (UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    User user;

    @Test
    public void whenPostCalled_canRegisterUser() throws Exception {
        given(userService.saveUser(anyString(),anyString(),anyString(),anyString())).willReturn(null);


        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/registration");
        mockHttpServletRequestBuilder.param("username","bohletest");
        mockHttpServletRequestBuilder.param("password","mypass321");
        mockHttpServletRequestBuilder.param("confirmPassword","mypass321");
        mockHttpServletRequestBuilder.param("email","none");

        mockMvc.perform(mockHttpServletRequestBuilder)
               .andExpect(status().isOk())
               .andDo(print());

    }

    @Test
    public void givenCorrectData_whenGetLogIn_thenReturnSuccess() throws Exception {
        given(userService.logIn(anyString(),anyString())).willReturn("Logged In Successfully");

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder= MockMvcRequestBuilders.get("/login");
        mockHttpServletRequestBuilder.param("username","bohledevs");
        mockHttpServletRequestBuilder.param("password","mypass321");

        MvcResult result = mockMvc.perform(mockHttpServletRequestBuilder)
                            .andExpect(status().isOk())
                            .andDo(print())
                            .andReturn();


        String content= result.getResponse().getContentAsString();

        System.out.println(content);

        assertEquals(content,"Logged In Successfully");
    }

    @Test
    public void canLogOut() throws Exception {
        given(userService.logOut(anyString())).willReturn("Successfully logged out");

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/logout");
        mockHttpServletRequestBuilder.param("username","bohledevs2");

        MvcResult result= mockMvc.perform(mockHttpServletRequestBuilder)
                                 .andExpect(status().isOk())
                                 .andDo(print())
                                 .andReturn();

        String content= result.getResponse().getContentAsString();

        assertEquals(content,"Successfully logged out");
    }

}
