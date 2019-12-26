package com.globant.user;


import com.globant.user.service.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK)

public class IntegrationTest {

  @Autowired
  TestRestTemplate restTemplate= new TestRestTemplate();

  @Test
  public void givenUsernameExists_whenMethodGetIsCalled_thenReturnUserData() {
    // arrange

    // act
    ResponseEntity<User> response= restTemplate.getForEntity("/users/bohledevs", User.class);

    // assert
    assertEquals("The request was unsuccesfull", response.getStatusCode(), HttpStatus.OK);
    assertEquals("The request retrieved incorrect information", response.getBody().getUsername(), "bohledevs");
    assertEquals("The nickname is erroneous", response.getBody().getNickname(), "facuXx2020");

    }

}
