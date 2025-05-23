package com.linkedbear.spring.environment.b_api.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EnvironmentHolder {
    
    @Autowired
    private Environment environment;
    
    public void printEnvironment() {
        System.out.println(environment.getProperty("jdbc.url"));
    }
}
