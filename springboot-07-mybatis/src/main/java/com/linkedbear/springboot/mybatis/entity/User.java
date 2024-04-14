package com.linkedbear.springboot.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    private String tel;
}
