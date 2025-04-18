package com.linkedbear.spring00.d_properties.factory;

import java.io.IOException;
import java.util.Properties;

public class BeanFactory {
    
    private static Properties properties;
    
    // 使用静态代码块初始化properties，加载factory_d.properties文件
    static {
        properties = new Properties();
        try {
            // 必须使用类加载器读取resource文件夹下的配置文件
            properties.load(BeanFactory.class.getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            // BeanFactory类的静态初始化都失败了，那后续也没有必要继续执行了
            throw new ExceptionInInitializerError("BeanFactory初始化失败" + e.getMessage());
        }
    }
    
    public static Object getBean(String beanName) {
        try {
            // 从properties文件中读取指定name对应类的全限定名，并反射实例化
            Class<?> beanClazz = Class.forName(properties.getProperty(beanName));
            return beanClazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("[" + beanName + "] instantiation error!", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}