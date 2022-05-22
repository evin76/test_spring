package com.example.test_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Aspect
@PropertySource("classpath:aspect.properties")
public class AspectTest {

    @Value("${aspect.count}")
    public String constCount;
    private int count;

    @Around("execution(* *(..)) && (within(One) || within(Two))")
    public Object timer(ProceedingJoinPoint point) throws Throwable {
        if(this.count <= Integer.parseInt(constCount) - 1) {
            this.count++;
            return point.proceed();
        } else {
            String str = "Exceeded maximum method call";
            Object obj = new String(str);
            return obj;
        }
    }
}
