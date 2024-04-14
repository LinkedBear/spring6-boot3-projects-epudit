package com.linkedbear.spring.bean.d_circledependency.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    
    private Cat cat;
    
    public Cat getCat() {
        return cat;
    }
    
    public void setCat(Cat cat) {
        this.cat = cat;
    }
    
    @Override
    public String toString() {
        return "Person{" + "cat=" + cat.hashCode() + '}';
    }
}
