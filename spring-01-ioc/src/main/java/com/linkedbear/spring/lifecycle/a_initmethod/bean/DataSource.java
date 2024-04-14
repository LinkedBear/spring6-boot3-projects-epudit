package com.linkedbear.spring.lifecycle.a_initmethod.bean;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    
    private String name;
    
    private List<String> connections;
    
    public DataSource() {
        System.out.println("DataSource 构造方法执行了。。。");
    }
    
    public List<String> getConnections() {
        return connections;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
        System.out.println("DataSource setName方法执行了。。。");
    }
    
    public void init() {
        this.connections = new ArrayList<>(10);
        System.out.println(name + "被初始化。。。");
    }
    
    public void destroy() {
        this.connections.clear();
        System.out.println(name + "被销毁。。。");
    }
}
