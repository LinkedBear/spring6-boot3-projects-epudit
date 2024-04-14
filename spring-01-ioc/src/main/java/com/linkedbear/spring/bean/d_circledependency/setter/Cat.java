package com.linkedbear.spring.bean.d_circledependency.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    
    private Person person;
    
    public Person getPerson() {
        return person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    @Override
    public String toString() {
        return "Cat{" + "person=" + person.hashCode() + '}';
    }
}
