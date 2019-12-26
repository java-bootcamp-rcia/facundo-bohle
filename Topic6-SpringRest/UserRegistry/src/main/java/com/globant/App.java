package com.globant;

import com.globant.user.service.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class App {
    public static void main (String[] args) {
        String resourceurl="http://localhost:8080/users/";
        RestTemplate restTemplate= new RestTemplate();

        HttpEntity<User> request= new HttpEntity<>(new User("bohle2","facu2","pass2","none"));

        User user= restTemplate.postForObject(resourceurl, request, User.class);

    }
}
