package com.linkedbear.springboot.aop.a_aspectj.service.impl;

import com.linkedbear.springboot.aop.a_aspectj.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Override
    public void createOrder() {
        System.out.println("OrderServiceImpl 创建订单。。。");
    }
    
    @Override
    public void deleteOrderById(String id) {
        System.out.println("OrderServiceImpl 删除订单，id为" + id);
    }
    
    @Override
    public String getOrderById(String id) {
        System.out.println("OrderServiceImpl 查询订单，id为" + id);
        return id;
    }
    
    @Override
    public List<String> findAll() {
        System.out.println("OrderServiceImpl 查询所有订单。。。");
        return Arrays.asList("111", "222", "333");
    }
}
