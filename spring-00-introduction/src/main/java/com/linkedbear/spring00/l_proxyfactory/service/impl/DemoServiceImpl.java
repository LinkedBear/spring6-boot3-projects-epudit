package com.linkedbear.spring00.l_proxyfactory.service.impl;

import com.linkedbear.spring00.l_proxyfactory.dao.DemoDao;
import com.linkedbear.spring00.l_proxyfactory.factory.BeanFactory;
import com.linkedbear.spring00.l_proxyfactory.service.DemoService;

import java.util.List;

public class DemoServiceImpl implements DemoService {
    
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
    
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
    
    @Override
    public int add(String userId, int points) {
        return points;
    }
    
    @Override
    public int subtract(String userId, int points) {
        return points;
    }
    
    @Override
    public int multiply(String userId, int points) {
        return points;
    }
    
    @Override
    public int divide(String userId, int points) {
        return points;
    }
}
