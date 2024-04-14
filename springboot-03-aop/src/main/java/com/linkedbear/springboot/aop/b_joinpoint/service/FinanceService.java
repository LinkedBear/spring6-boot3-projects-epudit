package com.linkedbear.springboot.aop.b_joinpoint.service;

import com.linkedbear.springboot.aop.b_joinpoint.annotation.Log;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {
    
    @Log
    public void addMoney(double money) {
        System.out.println("FinanceService 收钱 === " + money);
    }
    
    public double subtractMoney(double money) {
        System.out.println("FinanceService 付钱 === " + money);
        return money;
    }
    
    public double subtractMoney(double money, String id) throws Exception {
        System.out.println("FinanceService 付钱 === " + money);
        return money;
    }
    
    public double getMoneyById(String id) {
        System.out.println("FinanceService 查询账户，id为" + id);
        return Math.random();
    }
}
