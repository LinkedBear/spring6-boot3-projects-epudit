package com.linkedbear.springboot.aop;

import com.linkedbear.springboot.aop.d_self.service.UserService;
import com.linkedbear.springboot.aop.e_transaction.service.FinanceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication(scanBasePackages = "com.linkedbear.springboot.aop.e_transaction")
public class SpringBootAopApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootAopApplication.class, args);
//        FinanceService financeService = ctx.getBean(FinanceService.class);
//        financeService.addMoney(123.45);
//        financeService.subtractMoney(543.21);
//        financeService.getMoneyById("abc");
        
//        FinanceService financeService = ctx.getBean(FinanceService.class);
//        financeService.addMoney(123.45);
//        financeService.subtractMoney(543.21);
        
//        UserService userService = ctx.getBean(UserService.class);
//        userService.saveUser("abc");
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.transfer(1L, 2L, 100);
    }
}
