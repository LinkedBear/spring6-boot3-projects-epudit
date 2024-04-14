package com.linkedbear.springboot.practice.failure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IllegalPortChecker implements CommandLineRunner {
    
    @Value("${server.port:8080}")
    private int port;
    
    @Override
    public void run(String... args) {
        if (port > 10000) {
            throw new IllegalPortException(port);
        }
    }
}
