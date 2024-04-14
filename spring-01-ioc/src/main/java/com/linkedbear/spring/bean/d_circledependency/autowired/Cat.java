package com.linkedbear.spring.bean.d_circledependency.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    
    @Autowired
    Person person;
    
    @Override
    public String toString() {
        return "Cat{" + "person=" + person.hashCode() + '}';
    }
}
