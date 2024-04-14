package com.linkedbear.springboot.jdbc.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    protected JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
