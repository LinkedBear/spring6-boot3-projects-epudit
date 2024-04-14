package com.linkedbear.spring00.c_reflect.dao.impl;

import com.linkedbear.spring00.b_factory.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

public class DemoOracleDao implements DemoDao {
    
    @Override
    public List<String> findAll() {
        // jdbc operations ......
        System.out.println("DemoOracleDao findAll run ......");
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
