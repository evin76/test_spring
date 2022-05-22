package com.example.test_spring.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class ControllerJson {
    public JsonTest jsonTest;
    @RequestMapping(value = "/cont/json", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<JsonTest> getJson(@RequestBody Map<String, Object> test) {
        Random random = new Random();
        int id = random.nextInt(50);
        this.jsonTest = new JsonTest();
        this.jsonTest.setPrice(test.get("price").toString().replaceAll("[{}=]"," "));
        HashMap<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(id));
        map.put("date", test.get("info").toString().replaceAll("[{}=]"," ").split(" ")[2]);
        this.jsonTest.setInfo(map);

        for(String key : test.keySet()){
            System.out.println(key + " " + test.get(key).toString().replaceAll("[{}=]"," "));
        }
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<JsonTest> entity = new ResponseEntity<>(this.jsonTest,headers, HttpStatus.CREATED);
        System.out.println(entity);
        System.out.println();
        return entity;
    }
}
