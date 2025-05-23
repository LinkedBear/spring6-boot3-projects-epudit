package com.linkedbear.spring.basic_di.e_jsr250.bean;

import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class Bird {
    
    @Resource //d(name = "master")
    private Person person;
    
    @Override
    public String toString() {
        return "Bird{" + "person=" + person + '}';
    }
}
