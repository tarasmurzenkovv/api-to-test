package com.taras.murzenkov.jokesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class JokesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokesApiApplication.class, args);
    }

}
