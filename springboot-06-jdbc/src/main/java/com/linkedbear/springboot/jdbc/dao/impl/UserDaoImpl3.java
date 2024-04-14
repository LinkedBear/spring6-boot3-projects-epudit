package com.linkedbear.springboot.jdbc.dao.impl;

import com.linkedbear.springboot.jdbc.base.BaseDao;
import com.linkedbear.springboot.jdbc.dao.UserDao;
import com.linkedbear.springboot.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class UserDaoImpl3 extends BaseDao implements UserDao {
    
    @Override
    public void save(User user) {
        this.getJdbcTemplate().update("insert into tbl_user (name, tel) values (?, ?)", user.getName(), user.getTel());
    }
    
    @Override
    public User findById(Integer id) {
        List<User> userList = this.getJdbcTemplate()
                .query("select * from tbl_user where id = ?", new BeanPropertyRowMapper<>(User.class), id);
        return userList.size() > 0 ? userList.get(0) : null;
    }
    
    @Override
    public List<User> findAll() {
        return this.getJdbcTemplate().query("select * from tbl_user", new BeanPropertyRowMapper<>(User.class));
    }
}
