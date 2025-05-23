package com.linkedbear.spring00.l_proxyfactory.service.impl;

import com.linkedbear.spring00.l_proxyfactory.dao.DemoDao;
import com.linkedbear.spring00.l_proxyfactory.factory.BeanFactory;
import com.linkedbear.spring00.l_proxyfactory.service.DemoService;

import java.util.List;

public class DemoServiceImpl2 implements DemoService {
    
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
    
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
    
    @Override
    public int add(String userId, int points) {
        System.out.println("DemoServiceImpl2 add ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
    
    @Override
    public int subtract(String userId, int points) {
        System.out.println("DemoServiceImpl2 subtract ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
    
    @Override
    public int multiply(String userId, int points) {
        System.out.println("DemoServiceImpl2 multiply ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
    
    @Override
    public int divide(String userId, int points) {
        System.out.println("DemoServiceImpl2 divide ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
}
