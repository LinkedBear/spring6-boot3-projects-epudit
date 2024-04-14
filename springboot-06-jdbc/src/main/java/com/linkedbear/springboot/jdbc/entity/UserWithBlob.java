package com.linkedbear.springboot.jdbc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserWithBlob implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    private String tel;
    private byte[] photo;
}
