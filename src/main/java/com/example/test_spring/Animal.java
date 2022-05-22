package com.example.test_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//setter injection
@Component
@Profile("dev")
@ConfigurationProperties("dev")
public class Animal {

    @Value("${dev.name}")
    private String name;

    private Cat cat;
    private Dog dog;

    @Autowired
    public void setCat(Cat cat){
        this.cat = cat;
    }

    @Autowired
    @ConditionalOnExpression("#{!environment.getProperty('spring.profiles.active').contains('default')}")
    public void setDog(Dog dog){
        this.dog = dog;
    }

    public String makeSound(){
        return cat.meow();
    }

    public String bark(){
        return dog.wuf();
    }

    @Component
    public static class Cat{
        public String meow(){
            return "meow";
        }
    }

    @Component
    public static class Dog{
        public String wuf(){
            return "wuf";
        }
    }
}
