package com.linkedbear.springboot.jpa.service;

import com.linkedbear.springboot.jpa.dao.DepartmentDao;
import com.linkedbear.springboot.jpa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentDao departmentDao;
    
    @Transactional(rollbackFor = Exception.class)
    public void save() {
        Department department = new Department();
        department.setName("测试部门");
        department.setAddress("test test");
        departmentDao.save(department);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void update() {
        departmentDao.findById(1).ifPresent(department -> {
            department.setName("测试修改部门");
            departmentDao.save(department);
        });
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void delete() {
        departmentDao.deleteById(1);
        departmentDao.deleteAll();
        List<Integer> ids = List.of(1, 2, 3);
        departmentDao.deleteAllById(ids);
    }
    
    public void select() {
        List<Department> all = departmentDao.findAll();
        System.out.println(all);
        
        boolean exists = departmentDao.existsById(20);
        System.out.println(exists);
    }
}
