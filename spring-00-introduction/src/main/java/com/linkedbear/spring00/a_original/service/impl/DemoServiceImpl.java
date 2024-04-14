package com.linkedbear.spring00.a_original.service.impl;

import com.linkedbear.spring00.a_original.dao.DemoDao;
import com.linkedbear.spring00.a_original.dao.impl.DemoDaoImpl;
import com.linkedbear.spring00.a_original.service.DemoService;

import java.util.List;

public class DemoServiceImpl implements DemoService {
    
    DemoDao demoDao = new DemoDaoImpl();
    
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
