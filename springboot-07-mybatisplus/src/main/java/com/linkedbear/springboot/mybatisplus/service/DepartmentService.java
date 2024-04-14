package com.linkedbear.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linkedbear.springboot.mybatisplus.entity.Department;
import com.linkedbear.springboot.mybatisplus.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService extends ServiceImpl<DepartmentMapper, Department> {
    
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        Department department = new Department();
        department.setName("test mybatisplus");
        department.setPid(1);
        this.getBaseMapper().insert(department);
        
        List<Department> departmentList = this.getBaseMapper().selectList(null);
        departmentList.forEach(System.out::println);
    }
}
