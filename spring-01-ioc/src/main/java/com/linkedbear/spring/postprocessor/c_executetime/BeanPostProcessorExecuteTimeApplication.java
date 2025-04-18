package com.linkedbear.spring.postprocessor.c_executetime;

import com.linkedbear.spring.postprocessor.c_executetime.config.ExecuteTimeConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPostProcessorExecuteTimeApplication {
    
    public static void main(String[] args) throws Exception {
        new AnnotationConfigApplicationContext(ExecuteTimeConfiguration.class);
    }
}
