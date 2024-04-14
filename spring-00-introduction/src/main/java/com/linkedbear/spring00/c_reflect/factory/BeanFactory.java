package com.linkedbear.spring00.c_reflect.factory;

import com.linkedbear.spring00.c_reflect.dao.DemoDao;
import com.linkedbear.spring00.c_reflect.service.DemoService;

public class BeanFactory {
    
    public static DemoService getDemoService() {
        try {
            return (DemoService) Class.forName("com.linkedbear.spring00.c_reflect.service.impl.DemoServiceImpl")
                    .getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DemoService instantiation error, cause: " + e.getMessage());
        }
    }
    
    public static DemoDao getDemoDao() {
        try {
            return (DemoDao) Class.forName("com.linkedbear.spring00.c_reflect.dao.impl.DemoMySQLDao")
                    .getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DemoDao instantiation error, cause: " + e.getMessage());
        }
    }
    
}
