package com.linkedbear.springboot.jdbc.dao;

import com.linkedbear.springboot.jdbc.entity.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    User findById(Integer id);
    List<User> findAll();
}
