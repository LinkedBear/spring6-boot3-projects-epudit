package com.linkedbear.spring.basic_dl.d_withanno;

import com.linkedbear.spring.basic_dl.d_withanno.anno.Color;
import com.linkedbear.spring.basic_dl.d_withanno.config.WithAnnoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class WithAnnoApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(WithAnnoConfiguration.class);
        Map<String, Object> beans = ctx.getBeansWithAnnotation(Color.class);
        beans.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean.toString());
        });
    }
}
