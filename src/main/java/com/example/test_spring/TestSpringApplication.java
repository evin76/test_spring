package com.example.test_spring;

import com.example.test_spring.events.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackageClasses = {EventPublisher.class})
@RestController
@RequiredArgsConstructor
public class TestSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestSpringApplication.class, args);
    }

    @RequiredArgsConstructor
    public class eventsTest{
        final ApplicationEventPublisher applicationEventPublisher;

        @Bean
        public void basicMessage(){
            EventPublisher publisher = new EventPublisher(applicationEventPublisher);
            publisher.publishCustomEvent("publish basic message");
        }

        @Bean
        public void asyncMessage(){
            EventPublisher publisher = new EventPublisher(applicationEventPublisher);
            publisher.publishAsyncEvent("publish async message");
        }

        @Bean
        public void transOneMessage(){
            EventPublisher publisher = new EventPublisher(applicationEventPublisher);
            publisher.publishTransOneEvent("publish trans one message");
        }

        @Bean
        public void transTwoMessage(){
            EventPublisher publisher = new EventPublisher(applicationEventPublisher);
            publisher.publishTransTwoEvent("publish trans two message");
        }
    }

    @Controller
    public class HelloWorldController {

        @Autowired
        private ApplicationContext applicationContext;

        @RequestMapping("/hello")
        public String hello(@RequestParam(value="key", required=false, defaultValue="World") String name, Model model) {

            String[] beanNames = applicationContext.getBeanDefinitionNames();

            for (String beanName : beanNames) {

                System.out.println(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
            }

            model.addAttribute("name", name);

            return "helloworld";
        }
    }
}
