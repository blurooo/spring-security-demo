package com.blurooo.chapter4_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
public class AdminController {

    @GetMapping("hello")
    public String hello() {
        return "hello, admin";
    }

}
