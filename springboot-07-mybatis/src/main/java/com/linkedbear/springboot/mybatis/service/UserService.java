package com.linkedbear.springboot.mybatis.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkedbear.springboot.mybatis.entity.User;
import com.linkedbear.springboot.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Transactional(rollbackFor = Exception.class)
    public List<User> test() {
        User user = new User();
        user.setName("test mybatis");
        user.setTel("7654321");
        userMapper.save(user);
    
//        int i = 1 / 0;
        
        return userMapper.findAll();
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void testCache1() {
        System.out.println("发起第一次查询：");
        userMapper.findAll();
        System.out.println("发起第二次查询：");
        userMapper.findAll();
    }
    
    public List<User> testPage1() {
        PageHelper.startPage(1, 2);
        return userMapper.findAll();
    }
    
    public PageInfo<User> testPage2(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.findAll();
        return new PageInfo<>(userList);
    }
}
