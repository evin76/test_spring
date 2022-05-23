package com.example.test_spring.tasks3and4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//constructor injection
@Configuration
@Profile("test")
@ConfigurationProperties("test")
public class UserService{

    @Primary
    @Bean
    @ConditionalOnExpression("#{environment.getProperty('spring.profiles.active').contains('test')}")
    public User getUser(){
        return new User();
    }

    @PostConstruct
    public static void postConstruct(){
        System.out.println("Bean is created");
    }

    @Bean
    @ConditionalOnBean()
    public Schedule getSchedule(User user){
        return new Schedule(user);
    }

    @PreDestroy
    public static void postDestroy(){
        System.out.println("Bean is going to be destroyed");
    }

    @Component
    public class User{
        Schedule schedule;
        String hello() {
            return "Created a user";
        }

        public void setSchedule(Schedule schedule){
            this.schedule = schedule;
        }
    }

    @Component
    public class Schedule{
        private User user;

        public Schedule(User user){
            this.user = user;
        }

        public String createSchedule(){
            user.setSchedule(this);
            return "Created a schedule for user";
        }
    }
}
