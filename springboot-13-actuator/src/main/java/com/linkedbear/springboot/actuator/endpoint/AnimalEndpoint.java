package com.linkedbear.springboot.actuator.endpoint;

import com.linkedbear.springboot.starter.component.Cat;
import com.linkedbear.springboot.starter.component.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "animal")
public class AnimalEndpoint {
    
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    
    @ReadOperation
    public String read() {
        return "Cat信息: " + cat.toString() + "; Dog信息: " + dog.toString();
    }
}
