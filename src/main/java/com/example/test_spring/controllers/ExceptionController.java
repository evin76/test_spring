package com.example.test_spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @RequestMapping(value="/exception", method = RequestMethod.GET)
    public String testException(@RequestParam(required = false, defaultValue = "false") boolean e) throws ControllerTwoException{
        if(e){
            throw new ControllerTwoException("ControllerTwoException 502 bad gateway in class ExceptionController");
        }
        return "OK";
    }
}
