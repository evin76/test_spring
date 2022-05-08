package com.example.test_spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class ControllerOne {
    private ObjectMapper objectMapper;
    public JsonTest jsonTest;
    @RequestMapping(value = "/json/price/{price}/info/{date}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<JsonTest> getJson(@PathVariable String price, @PathVariable String date) throws IOException {
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
