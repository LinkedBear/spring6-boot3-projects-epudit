package com.linkedbear.spring.definition.d_removedefinition.config;

import com.linkedbear.spring.definition.d_removedefinition.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;

@Component
public class RemoveBeanDefinitionPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
        // 获取IOC容器中的所有BeanDefinition
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            // 判断BeanDefinition对应的Bean是否为Person类型
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            if (Person.class.getName().equals(beanDefinition.getBeanClassName())) {
                // 判断Person的年龄是否大于等于18，小于18的会被移除
                TypedStringValue age = (TypedStringValue) beanDefinition.getPropertyValues().get("age");
                if (Integer.parseInt(age.getValue()) < 18) {
                    // 移除BeanDefinition
                    registry.removeBeanDefinition(beanDefinitionName);
                }
            }
        }
    }
}
