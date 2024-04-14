package com.linkedbear.spring.bean.d_circledependency;

import com.linkedbear.spring.bean.d_circledependency.prototype.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrototypeDependencyApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.bean.d_circledependency.prototype");
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
