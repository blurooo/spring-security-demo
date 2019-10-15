package com.blurooo.chapter3_2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blurooo.chapter3_2.mapper")
public class Chapter32Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter32Application.class, args);
    }

}
