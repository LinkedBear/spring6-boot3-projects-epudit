package com.linkedbear.springboot.jetcache.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.linkedbear.springboot.jetcache.entity.User;
import com.linkedbear.springboot.jetcache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationUserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Cached(name = "anno.getUser.", key = "#id")
    public User get(Integer id) {
        return userMapper.selectById(id);
    }
    
    public List<User> findAll() {
        return userMapper.selectList(null);
    }
    
    public List<User> findAllByName(String name) {
        return userMapper.selectList(Wrappers.lambdaQuery(User.class).like(User::getName, name));
    }
    
    @CacheUpdate(name = "anno.getUser.", key = "#user.id", value = "#result")
    public User update(User user) {
        userMapper.updateById(user);
        return user;
    }
    
    @CacheInvalidate(name = "anno.getUser.", key = "#id")
    public void deleteById(Integer id) {
//        userMapper.deleteById(id);
        System.out.println("deleteById invoke ......");
    }
}
