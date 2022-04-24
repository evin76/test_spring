package com.example.test_spring.events;

import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class TransEventListener {
    @SneakyThrows
    //@EventListener
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void listenEventOne(TransEventOne event){
        System.out.println(event.getMessage());
    }

    @SneakyThrows
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void listenEventTwo(TransEventTwo event){
        System.out.println(event.getMessage());
    }
}
