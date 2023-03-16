package com.example.posttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PosttestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosttestApplication.class, args);
    }

}
