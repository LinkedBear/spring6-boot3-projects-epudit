package com.linkedbear.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
@TableName("tbl_dept")
public class Department {
    
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    @Version
    private Integer version;
    
    private String name;
    
    private Integer pid;
    
    @TableLogic
    private Boolean del;
}
