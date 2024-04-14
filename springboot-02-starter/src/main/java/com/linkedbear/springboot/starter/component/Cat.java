package com.linkedbear.springboot.starter.component;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "animal.cat")
public class Cat {
    
    private String name;
    
    private Integer age;
    
    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
}
