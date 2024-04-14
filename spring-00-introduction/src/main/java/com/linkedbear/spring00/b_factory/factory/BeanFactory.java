package com.linkedbear.spring00.b_factory.factory;

import com.linkedbear.spring00.b_factory.dao.DemoDao;
import com.linkedbear.spring00.b_factory.dao.impl.DemoDaoImpl;
import com.linkedbear.spring00.b_factory.dao.impl.DemoMySQLDao;
import com.linkedbear.spring00.b_factory.service.DemoService;
import com.linkedbear.spring00.b_factory.service.impl.DemoServiceImpl;

public class BeanFactory {
    
    public static DemoService getDemoService() {
        return new DemoServiceImpl();
    }
    
    public static DemoDao getDemoDao() {
//        return new DemoDaoImpl();
        return new DemoMySQLDao();
    }
    
}
