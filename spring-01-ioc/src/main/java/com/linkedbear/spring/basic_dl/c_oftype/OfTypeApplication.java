package com.linkedbear.spring.basic_dl.c_oftype;

import com.linkedbear.spring.basic_dl.c_oftype.config.OfTypeConfiguration;
import com.linkedbear.spring.basic_dl.c_oftype.dao.DemoDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class OfTypeApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(OfTypeConfiguration.class);
        Map<String, DemoDao> beans = ctx.getBeansOfType(DemoDao.class);
        beans.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean.toString());
        });
    }
}
