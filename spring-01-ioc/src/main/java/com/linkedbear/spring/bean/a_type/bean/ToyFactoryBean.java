package com.linkedbear.spring.bean.a_type.bean;

import org.springframework.beans.factory.FactoryBean;

public class ToyFactoryBean implements FactoryBean<Toy> {
    
    public ToyFactoryBean() {
        System.out.println("ToyFactoryBean 初始化了。。。");
    }
    
    private Child child;
    
    @Override
    public Toy getObject() {
        return switch (child.getWantToy()) {
            case "ball" -> new Ball("ball");
            case "car" -> new Car("car");
            default -> null;
        };
    }
    
    @Override
    public Class<Toy> getObjectType() {
        return Toy.class;
    }
    
    public void setChild(Child child) {
        this.child = child;
    }
}
