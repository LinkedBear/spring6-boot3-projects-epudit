package com.linkedbear.spring.bean.d_circledependency;

import com.linkedbear.spring.bean.d_circledependency.autowired.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredDependencyApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.bean.d_circledependency.autowired");
        System.out.println(ctx.getBean(Person.class));
    }
}
