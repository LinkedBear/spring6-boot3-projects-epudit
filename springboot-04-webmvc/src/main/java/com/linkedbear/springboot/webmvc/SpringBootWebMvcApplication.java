package com.linkedbear.springboot.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBootWebMvcApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcApplication.class, args);
    }
}
