package com.example.test_spring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ControllerTwoException extends Exception {
    public  ControllerTwoException(String message){
        super(message);
    }
}
