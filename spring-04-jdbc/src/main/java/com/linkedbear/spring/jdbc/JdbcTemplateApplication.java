package com.linkedbear.spring.jdbc;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateApplication {
    
    public static void main(String[] args) {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/spring-dao?characterEncoding=utf8");
//        dataSource.setUsername("springboot");
//        dataSource.setPassword("123456");
        
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring-dao?characterEncoding=utf8");
        dataSource.setUsername("springboot");
        dataSource.setPassword("123456");
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("insert into tbl_user (name, tel) values ('hahaha', '12345')");
    }
}
