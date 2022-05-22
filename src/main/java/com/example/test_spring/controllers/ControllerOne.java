package com.example.test_spring.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class ControllerOne {
    public JsonTest jsonTest;
    @RequestMapping(value = "/json/price/{price}/info/{date}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<JsonTest> getJson(@PathVariable String price, @PathVariable String date) {
        Random random = new Random();
        int id = random.nextInt(50);
        jsonTest = new JsonTest();
        jsonTest.setPrice(price);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(id));
        map.put("date", date);
        jsonTest.setInfo(map);
        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<JsonTest> entity = new ResponseEntity<>(jsonTest,headers, HttpStatus.CREATED);

        return entity;
    }
}
