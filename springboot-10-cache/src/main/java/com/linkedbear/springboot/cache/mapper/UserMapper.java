package com.linkedbear.springboot.cache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linkedbear.springboot.cache.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    
}
