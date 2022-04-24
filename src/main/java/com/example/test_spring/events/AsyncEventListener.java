package com.example.test_spring.events;

import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncEventListener {

    @EventListener
    @SneakyThrows
    @Async
    public void listenEvent(AsyncEvent event){
        Thread.sleep(1000);
        System.out.println(event.getMessage());
    }
}
