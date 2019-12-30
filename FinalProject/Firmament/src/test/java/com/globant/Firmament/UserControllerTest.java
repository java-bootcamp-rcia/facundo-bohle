package com.globant.Firmament;


import com.globant.Firmament.user.controller.UserController;
import com.globant.Firmament.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest (UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void whenPostCalled_canRegisterUser() throws Exception {
        when(userService.save(anyString(),anyString(),anyString(),anyString())).thenReturn("Sucess");


        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/registration");
        mockHttpServletRequestBuilder.param("username","bohletest");
        mockHttpServletRequestBuilder.param("password","mypass321");
        mockHttpServletRequestBuilder.param("confirmPassword","mypass321");
        mockHttpServletRequestBuilder.param("email","none");

        mockMvc.perform(mockHttpServletRequestBuilder)
               .andExpect(status().isOk())
               .andDo(print());

    }
}
