package com.linkedbear.spring00.b_factory.service.impl;

import com.linkedbear.spring00.b_factory.dao.DemoDao;
import com.linkedbear.spring00.b_factory.factory.BeanFactory;
import com.linkedbear.spring00.b_factory.service.DemoService;

import java.util.List;

public class DemoServiceImpl2 implements DemoService {
    
    DemoDao demoDao = BeanFactory.getDemoDao();
    
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
