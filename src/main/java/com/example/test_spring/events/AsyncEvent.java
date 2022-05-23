package com.example.test_spring.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
public class AsyncEvent extends ApplicationEvent {
    private String message;

    public AsyncEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    @Autowired
    public void setMessage(String message) {
        this.message = message;
    }

    @Bean(name = "AsyncEvent")
    public String getMessage(){
        return message;
    }
}
