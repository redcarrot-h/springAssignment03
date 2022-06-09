package com.sparta.springassignment02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringAssignment02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringAssignment02Application.class, args);
    }

}
