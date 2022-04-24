package com.example.test_spring.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

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

    @Autowired
    public String getMessage(){
        return message;
    }
}
