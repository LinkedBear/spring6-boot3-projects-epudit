package com.linkedbear.spring.bean.d_circledependency;

import com.linkedbear.spring.bean.d_circledependency.constructor.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConstructorDependencyApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.bean.d_circledependency.constructor");
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
