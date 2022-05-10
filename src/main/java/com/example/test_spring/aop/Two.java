package com.example.test_spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Two implements Service{
    @Override
    public String hello() {
        System.out.println("Hi from class Two");
        return "Hi from class Two";
    }
}
