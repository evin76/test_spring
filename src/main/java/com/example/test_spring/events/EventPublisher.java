package com.example.test_spring.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Controller
public class EventPublisher {
    final ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message){
        BasicEvent basicEvent = new BasicEvent(this, message);
        logEvent(basicEvent);
        System.out.println("Published custom event");
        applicationEventPublisher.publishEvent(basicEvent);
    }

    public void publishAsyncEvent(final String message){
        AsyncEvent asyncEvent = new AsyncEvent(this, message);
        logEvent(asyncEvent);
        System.out.println("Published async event");
        applicationEventPublisher.publishEvent(asyncEvent);
    }

    public void publishTransOneEvent(final String message){
        TransEventOne transEvent = new TransEventOne(this, message);
        logEvent(transEvent);
        System.out.println("Published trans event one");
        applicationEventPublisher.publishEvent(transEvent);
    }

    public void publishTransTwoEvent(final String message){
        TransEventTwo transEvent = new TransEventTwo(this, message);
        logEvent(transEvent);
        System.out.println("Published trans event two");
        applicationEventPublisher.publishEvent(transEvent);
    }

    private void logEvent(Object event) {
        if (event instanceof BasicEvent) {
            System.out.println("eventName " + ((BasicEvent) event).getMessage().getClass() + "event " + ((BasicEvent) event).getMessage() + " publishing...");
        } else {
            System.out.println("eventName " + event.getClass() + "event " + event + " publishing ...");
        }
    }
}
