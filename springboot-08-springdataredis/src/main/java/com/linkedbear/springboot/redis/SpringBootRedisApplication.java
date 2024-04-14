package com.linkedbear.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories
@SpringBootApplication
public class SpringBootRedisApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }
}
