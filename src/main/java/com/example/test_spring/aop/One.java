package com.example.test_spring.aop;

//import lombok.Value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:aspect.properties")
public class One implements Service{

    //Environment env;
    @Value("${aspect.count}")
    public String count;

    @Override
    //@ConditionalOnExpression("#{environment.getProperty('aspect.count').contains(3)}")
    public String hello() {
        System.out.println("Hi form class One " + this.count);
        //int max = Integer.parseInt(env.getProperty("aspect.count").toString());
       /*for(int i = 0; i < 5; i++){
            count++;
            //if(max != this.count){
                System.out.println("found it properties work, count equals " + count);
                check();
            //}
        }*/
        return "Hi form class One " + this.count;
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
