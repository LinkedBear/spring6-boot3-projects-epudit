package com.linkedbear.spring.bean.d_circledependency.incompleteconstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    
    @Autowired
    Person person;
    
//    @Autowired
//    public Cat(Person person) {
//        this.person = person;
//    }
    
    @Override
    public String toString() {
        return "Cat{" + "person=" + person.hashCode() + '}';
    }
}
