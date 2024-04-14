package com.linkedbear.spring.basic_di.f_jsr330.bean;

import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Component
public class Cat {
    
    private String name = "mimi";
    
    @Inject
    @Named("admin")
    private Person master;
    
    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", master=" + master + '}';
    }
}
