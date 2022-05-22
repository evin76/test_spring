package com.example.test_spring.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class BasicEventListener implements ApplicationListener<BasicEvent> {

    @Override
    public void onApplicationEvent(BasicEvent event) {
        System.out.println(event.getMessage());
    }

}
