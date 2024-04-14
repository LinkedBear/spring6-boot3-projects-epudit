package com.linkedbear.spring.bean.d_circledependency.incompleteconstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    
//    @Autowired
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
