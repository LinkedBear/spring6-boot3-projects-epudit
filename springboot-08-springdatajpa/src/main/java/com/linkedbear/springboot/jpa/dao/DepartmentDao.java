package com.linkedbear.springboot.jpa.dao;

import com.linkedbear.springboot.jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
    
}
