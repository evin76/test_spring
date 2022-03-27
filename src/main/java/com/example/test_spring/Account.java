package com.example.test_spring;

import org.springframework.stereotype.Component;

@Component
public class Account {
    public String createAccount(){
        return "Account is created, you can play now";
    }
}
