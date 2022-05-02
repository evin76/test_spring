package com.example.test_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerTwo {
    public Person person;

    @GetMapping("/person")
    @ResponseBody
    public String getPerson(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("job") String job){
        person = new Person(name, age, job);
        return person.toString();
    }
}
