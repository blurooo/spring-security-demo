package com.blurooo.chapter4_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/api")
public class AppController {

    @GetMapping("hello")
    public String hello() {
        return "hello, app";
    }

}
