package com.example.test_spring;

import com.example.test_spring.controllers.ControllerJson;
import com.example.test_spring.controllers.ControllerOne;
import com.example.test_spring.controllers.ControllerThree;
import com.example.test_spring.controllers.ControllerTwo;
import com.example.test_spring.events.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackageClasses = {EventPublisher.class, ControllerTwo.class, ControllerOne.class, ControllerThree.class,
        ControllerJson.class})
@RestController
@RequiredArgsConstructor
public class TestSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestSpringApplication.class, args);
    }

}
