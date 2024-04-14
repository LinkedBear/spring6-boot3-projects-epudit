package com.linkedbear.springboot.jdbc.service;

import com.linkedbear.springboot.jdbc.dao.UserDao;
import com.linkedbear.springboot.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    public void saveAndQuery() {
        User user = new User();
        user.setName("测试保存用户");
        user.setTel("123654789");
        userDao.save(user);
        
        int i = 1 / 0;
        
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }
    
    @Autowired
    private TransactionTemplate transactionTemplate;
    
    public void saveAndQuery2() {
        transactionTemplate.executeWithoutResult(transactionStatus -> {
            User user = new User();
            user.setName("测试保存用户2");
            user.setTel("123654789");
            userDao.save(user);
            
            int i = 1 / 0;
            
            List<User> userList = userDao.findAll();
            System.out.println(userList);
        });
    }
    
    @Transactional
    public void saveAndQuery3() {
        User user = new User();
        user.setName("测试保存用户");
        user.setTel("123654789");
        userDao.save(user);
        
        int i = 1 / 0;
        
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }
}
