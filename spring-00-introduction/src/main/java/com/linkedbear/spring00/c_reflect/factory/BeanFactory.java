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
            throw new RuntimeException("DemoService初始化失败：" + e.getMessage());
        }
    }
    
    public static DemoDao getDemoDao() {
        try {
            return (DemoDao) Class.forName("com.linkedbear.spring00.c_reflect.dao.impl.DemoMySQLDao")
                    .getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DemoDao初始化失败：" + e.getMessage());
        }
    }
    
}
