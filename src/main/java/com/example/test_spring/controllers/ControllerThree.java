package com.example.test_spring.controllers;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerThree {
    public Person person;
    @RequestMapping(value = "/person/info/{name}/{age}/{job}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getPersonInfo(@PathVariable String name, @PathVariable int age, @PathVariable String job){
        person = new Person(name, age, job);
        return person.toString();
    }
}
