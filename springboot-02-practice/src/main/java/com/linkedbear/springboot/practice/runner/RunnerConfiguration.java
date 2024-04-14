package com.linkedbear.springboot.practice.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunnerConfiguration {
    
    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println("CommandLineRunner run ......");
        };
    }
}
