package com.example.test_spring;

import com.example.test_spring.controllers.ControllerJson;
import com.example.test_spring.controllers.ControllerOne;
import com.example.test_spring.controllers.ControllerThree;
import com.example.test_spring.controllers.ControllerTwo;
import com.example.test_spring.events.BasicEvent;
import com.example.test_spring.events.BasicEventListener;
import com.example.test_spring.events.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackageClasses = {EventPublisher.class, ControllerTwo.class, ControllerOne.class, ControllerThree.class,
        ControllerJson.class})
@RestController
@RequiredArgsConstructor
public class TestSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestSpringApplication.class, args);
        //collectClasses();
    }

    @RequiredArgsConstructor
    public class eventsTest{
        final ApplicationEventPublisher applicationEventPublisher;

        @Bean
        public void basicMessage(){
            //BasicEventListener eventListener = new BasicEventListener();
            //eventListener.onApplicationEvent(new BasicEvent(applicationEventPublisher, "basic message"));
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

    @GetMapping("/test")
    public static String test(){
        return "Hi there";
    }

    @RestController
    public static class Cat{
        @GetMapping("/cat")
        public String meow(){
            return "meow";
        }
    }

    //@GetMapping("/classCreation")
    @Bean
    public static void collectClasses(){
        //@Autowired
        // publisher = null;
        UserService userService = new UserService();
        UserService.User user = userService.getUser();

        Animal animal = new Animal();
        Animal.Cat cat = new Animal.Cat();
        Animal.Dog dog = new Animal.Dog();
        animal.setCat(cat);
        animal.setDog(dog);

        Account account = new Account();
        Game game = new Game(account);

        System.out.println(animal.makeSound());
        System.out.println(animal.bark());
        System.out.println(user.hello());
        System.out.println(userService.getSchedule(user).createSchedule());
        System.out.println(game.startGame());
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
