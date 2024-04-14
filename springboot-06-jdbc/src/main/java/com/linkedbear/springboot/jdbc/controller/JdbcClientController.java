package com.linkedbear.springboot.jdbc.controller;

import com.linkedbear.springboot.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbcclient")
public class JdbcClientController {
    
    @Autowired
    private JdbcClient jdbcClient;
    
    @GetMapping("/test1") // 带有参数的指定结果集类型的列表查询
    public List<User> test1() {
        return jdbcClient.sql("select * from tbl_user where id > ?").param(2).query(User.class).list();
    }
    
    @GetMapping("/test2") // 使用RowMapper指定返回数据类型
    public List<Map<String, Object>> test2() {
        return jdbcClient.sql("select * from tbl_user").query(new ColumnMapRowMapper()).list();
    }
    
    @GetMapping("/test3") // 查询单条数据
    public User test3() {
        return jdbcClient.sql("select * from tbl_user where id = ?").param("1").query(User.class).single();
    }
    
    @GetMapping("/test4") // 使用update完成数据修改，同时使用了带名称的参数
    public int test4() {
        return jdbcClient.sql("update tbl_user set tel = :tel where id = :id")
                .param("tel", "123456").param("id", 1).update();
    }
}
