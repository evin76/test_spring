package com.example.test_spring.aop;

import org.springframework.stereotype.Component;

@Component
public class One implements Service{
    @Override
    public String hello() {
        System.out.println("Hi form class One");
        return "Hi form class One";
    }
}
