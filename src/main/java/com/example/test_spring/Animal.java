package com.example.test_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//setter injection
@Component
public class Animal {

    private Cat cat;
    private Dog dog;

    @Autowired
    public void setCat(Cat cat){
        this.cat = cat;
    }

    @Autowired
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
