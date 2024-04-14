package com.linkedbear.springboot.aop.d_self.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    public void update(String id, String name) {
        this.get(id);
        System.out.println("修改指定id的name。。。");
    }
    
    public void get(String id) {
        System.out.println("获取指定id的user。。。");
    }
}
