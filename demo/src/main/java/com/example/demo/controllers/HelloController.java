package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HelloController {

    @GetMapping("app/foo")
    public Map<String, String> foo(){
        Map<String, String> json = new HashMap<>();
        json.put("message", "hello world");
        return json;
    }
}
