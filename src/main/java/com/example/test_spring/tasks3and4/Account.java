package com.example.test_spring.tasks3and4;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class Account {
    public String createAccount(){
        return "Account is created, you can play now";
    }
}
