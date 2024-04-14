package com.linkedbear.springboot.jpa.service;

import com.linkedbear.springboot.jpa.dao.UserDao;
import com.linkedbear.springboot.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    public User save() {
        User user = new User();
        user.setName("test springdatajpa");
        user.setTel("123321");
        return userDao.save(user);
    }
    
    public void select() {
        Page<User> userPage = userDao.findAll(PageRequest.of(0, 2));
        System.out.println(userPage.getTotalElements());
        System.out.println(userPage.getTotalPages());
        System.out.println(userPage.getContent());
    }
}
