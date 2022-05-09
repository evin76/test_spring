package com.example.test_spring.aop;

//import lombok.Value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:aspect.properties")
public class One implements Service{

    //Environment env;
    @Value("${aspect.count}")
    public String count;

    @Override
    //@ConditionalOnExpression("#{environment.getProperty('aspect.count').contains(3)}")
    public void hello() {
        System.out.println("Hi form class One " + count);
        //int max = Integer.parseInt(env.getProperty("aspect.count").toString());
       /*for(int i = 0; i < 5; i++){
            count++;
            //if(max != this.count){
                System.out.println("found it properties work, count equals " + count);
                check();
            //}
        }*/
    }

    //@ConditionalOnExpression("#{!environment.getProperty('aspect.count').contains(3)}")
    public void check(){
        System.out.println("Method check is called");
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCount() {
        return count;
    }

    //public void setCount(String count) {
    //}
}
