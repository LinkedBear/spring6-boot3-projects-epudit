package com.linkedbear.spring.bean.d_circledependency.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cat {
    
    @Autowired
    Person person;
    
    @Override
    public String toString() {
        return "Cat{" + "person=" + person.hashCode() + '}';
    }
}
