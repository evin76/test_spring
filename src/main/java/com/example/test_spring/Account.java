package com.example.test_spring;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class Account {
    public String createAccount(){
        return "Account is created, you can play now";
    }
}
