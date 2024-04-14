package com.linkedbear.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SpringBootJpaApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }
}
