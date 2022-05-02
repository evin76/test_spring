package com.example.test_spring.controllers;

public class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job){
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String toString(){
        return "Name is " + this.name + ", age is " + this.age + ", job is " + this.job;
    }
}
