package com.linkedbear.springboot.jdbc.dao.impl;

import com.linkedbear.springboot.jdbc.dao.UserDao;
import com.linkedbear.springboot.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into tbl_user (name, tel) values (?, ?)", user.getName(), user.getTel());
    }
    
    @Override
    public User findById(Integer id) {
        List<User> userList = jdbcTemplate
                .query("select * from tbl_user where id = ?", new BeanPropertyRowMapper<>(User.class), id);
        return userList.size() > 0 ? userList.get(0) : null;
    }
    
    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from tbl_user", new BeanPropertyRowMapper<>(User.class));
    }
}
