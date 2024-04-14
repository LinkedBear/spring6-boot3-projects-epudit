package com.linkedbear.springboot.starter.component;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "animal.dog")
public class Dog {
    
    /**
     * 狗狗的名字
     */
    private String name;
    
    /**
     * 狗狗的性别 1雄性 0雌性
     */
    private Integer sex;
    
    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", sex=" + sex + '}';
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getSex() {
        return sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
