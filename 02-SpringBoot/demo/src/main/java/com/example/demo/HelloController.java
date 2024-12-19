package com.example.demo;
// package main.java.com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("api/hello")
    public String sayHelloApi() {
        return "Hola mundo desde mi API";
    }

}