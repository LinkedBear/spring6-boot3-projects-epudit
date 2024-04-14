package com.linkedbear.spring.bean.d_circledependency.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    
    Cat cat;
    
    @Autowired
    public Person(Cat cat) {
        this.cat = cat;
    }
    
    @Override
    public String toString() {
        return "Person{" + "cat=" + cat.hashCode() + '}';
    }
}
