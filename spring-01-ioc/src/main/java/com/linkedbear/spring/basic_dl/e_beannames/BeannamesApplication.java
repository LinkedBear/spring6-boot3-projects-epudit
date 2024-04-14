package com.linkedbear.spring.basic_dl.e_beannames;

import com.linkedbear.spring.basic_dl.d_withanno.config.WithAnnoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class BeannamesApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(WithAnnoConfiguration.class);
        String[] beanNames = ctx.getBeanDefinitionNames();
        Stream.of(beanNames).forEach(System.out::println);
    }
}
