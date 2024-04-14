package com.linkedbear.springboot.jetcache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linkedbear.springboot.jetcache.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    
}
