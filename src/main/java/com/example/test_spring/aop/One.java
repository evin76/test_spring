package com.example.test_spring.aop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:aspect.properties")
public class One implements Service{

    //Environment env;
    @Value("${aspect.count}")
    public String count;

    @Override
    public String hello() {
        System.out.println("Hi form class One " + count);
        return "Hi form class One " + count;
    }

    public void check(){
        System.out.println("Method check is called");
    }
}
