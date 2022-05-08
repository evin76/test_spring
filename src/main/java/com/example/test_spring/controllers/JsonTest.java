package com.example.test_spring.controllers;

import lombok.Data;

import java.util.HashMap;

@Data
public class JsonTest {
    private String price;
    private HashMap<String, String> info;
}
