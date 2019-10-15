package com.blurooo.chapter4_2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blurooo.chapter4_2.mapper")
public class Chapter42Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter42Application.class, args);
    }

}
