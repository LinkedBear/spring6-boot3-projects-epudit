package com.linkedbear.springboot.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class SpringBootMongodbApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbApplication.class, args);
    }
}
