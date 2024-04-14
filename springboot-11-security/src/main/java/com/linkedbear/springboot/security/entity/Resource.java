package com.linkedbear.springboot.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_resource")
public class Resource {
    
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String name;
    
    private String permission;
}
