package com.blurooo.chapter4_1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blurooo.chapter4_1.mapper")
public class Chapter41Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter41Application.class, args);
    }

}
