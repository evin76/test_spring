package com.example.test_spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Two implements Service{
    @Override
    public String hello() {
        System.out.println("Hi from class Two");

        //ApplicationContext context
                //= new ClassPathXmlApplicationContext(
                //"beans.xml");
        //One one = context.getBean("one", One.class);
        //System.out.println("here is count " + one.getCount());
        return null;
    }
}
