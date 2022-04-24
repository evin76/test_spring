package com.example.test_spring.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class BasicEventListener implements ApplicationListener<BasicEvent> {
    //final ExecutorService executorService = Executors.newSingleThreadExecutor();
    //final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onApplicationEvent(BasicEvent event) {
        System.out.println(event.getMessage());
    }

}
