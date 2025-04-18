package com.linkedbear.spring.definition.d_removedefinition;

import com.linkedbear.spring.definition.d_removedefinition.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RemoveBeanDefinitionApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("definition/remove-definitions.xml");
        Person dazhuang = (Person) ctx.getBean("dazhuang");
        System.out.println(dazhuang);
        Person xiaoming = (Person) ctx.getBean("xiaoming");
        System.out.println(xiaoming);
    }
}
