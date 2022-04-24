package com.example.test_spring.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

public class TransEventOne extends ApplicationEvent {
    private String message;

    public TransEventOne(Object source, String message) {
        super(source);
        this.message = message;
    }

    @Autowired
    public void setMessage(String message) {
        this.message = message;
    }

    @Autowired
    public String getMessage(){
        return message;
    }
}
