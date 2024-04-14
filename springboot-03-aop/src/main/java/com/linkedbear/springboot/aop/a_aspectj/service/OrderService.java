package com.linkedbear.springboot.aop.a_aspectj.service;

import java.util.List;

public interface OrderService {
    
    void createOrder();
    
    void deleteOrderById(String id);
    
    String getOrderById(String id);
    
    List<String> findAll();
}
