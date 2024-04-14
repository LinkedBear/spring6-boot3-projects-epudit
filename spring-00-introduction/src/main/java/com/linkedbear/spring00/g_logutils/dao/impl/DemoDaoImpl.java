package com.linkedbear.spring00.g_logutils.dao.impl;

import com.linkedbear.spring00.g_logutils.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

public class DemoDaoImpl implements DemoDao {
    
    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
