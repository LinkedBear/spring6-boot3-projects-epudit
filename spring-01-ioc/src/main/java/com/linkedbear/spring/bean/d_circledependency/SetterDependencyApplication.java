package com.linkedbear.spring.bean.d_circledependency;

import com.linkedbear.spring.bean.d_circledependency.setter.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDependencyApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean/bean-setter-dependency.xml");
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
