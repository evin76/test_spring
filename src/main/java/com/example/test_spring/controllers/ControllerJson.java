package com.example.test_spring.controllers;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class ControllerJson {
    public JsonTest jsonTest;
    public List<JsonTest> lst;
    //public static jsonBrowser jsonBrowser;
    /* REQUEST EXAMPLE
    curl -H "Accept: application/json" -H "Content-type: application/json" \
    -X POST -d '{"price": 125.0, "info": {"date": "2022-01-01"}}' http://localhost:8080/cont/json/
    в терминал возвращает json с id
    * */
    @RequestMapping(value = "/cont/json", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    //this method get json and prints it to console
    public ResponseEntity<JsonTest> getJson(@RequestBody Map<String, Object> test) throws IOException {
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
        System.out.println(test);
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<JsonTest> entity = new ResponseEntity<>(this.jsonTest,headers, HttpStatus.CREATED);
        //return test;
        System.out.println(entity);
        System.out.println();
        this.lst = new ArrayList<>();
        this.lst.add(this.jsonTest);
        //getJson(this.lst);
        //ControllerJson.jsonBrowser.seeJson(this.jsonTest);
        return entity;
    }

    /*this method can display json in browser http://localhost:8080/json/see/
    @Controller
    public static class jsonBrowser {
        @RequestMapping(value = "/cond/see/json", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
        @ResponseBody
        public static ResponseEntity<JsonTest> seeJson(JsonTest lst) throws IOException {
            HttpHeaders headers = new HttpHeaders();
            ResponseEntity<JsonTest> entity = new ResponseEntity<>(lst, headers, HttpStatus.CREATED);
            return entity;
        }
    }

     */
}
