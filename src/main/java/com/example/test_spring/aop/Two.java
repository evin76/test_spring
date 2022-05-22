package com.example.test_spring.aop;
import org.springframework.stereotype.Component;

@Component
public class Two implements Service{
    @Override
    public String hello() {
        System.out.println("Hi from class Two");
        return "Hi from class Two";
    }
}
