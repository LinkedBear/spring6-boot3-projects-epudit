package com.linkedbear.spring.postprocessor.h_factoryprocessor.config;

import com.linkedbear.spring.postprocessor.h_factoryprocessor.bean.Color;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.stream.Stream;

@Component
public class ColorNameSetterFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Stream.of(beanFactory.getBeanDefinitionNames()).forEach(beanName -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            String beanClassName = beanDefinition.getBeanClassName();
            if (StringUtils.hasText(beanClassName)) {
                ClassLoader classLoader = this.getClass().getClassLoader();
                Class<?> superclass = ClassUtils.resolveClassName(beanClassName, classLoader).getSuperclass();
                if (superclass.equals(Color.class)) {
                    System.out.println("Color definition name setting ...... " + beanName);
                    beanDefinition.getPropertyValues().add("name", beanName);
                }
            }
        });
    }
}
