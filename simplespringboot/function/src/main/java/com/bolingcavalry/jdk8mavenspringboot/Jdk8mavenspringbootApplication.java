package com.bolingcavalry.jdk8mavenspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan(basePackages = {"com.bolingcavalry.*.mapper"})

public class Jdk8mavenspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Jdk8mavenspringbootApplication.class, args);
    }
}
