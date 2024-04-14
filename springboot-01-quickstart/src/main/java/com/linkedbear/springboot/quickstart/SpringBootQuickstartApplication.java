package com.linkedbear.springboot.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootQuickstartApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootQuickstartApplication.class, args);
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
