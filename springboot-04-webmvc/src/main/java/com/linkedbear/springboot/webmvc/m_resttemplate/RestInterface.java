package com.linkedbear.springboot.webmvc.m_resttemplate;

import com.linkedbear.springboot.webmvc.c_requestparam.Department;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("http://localhost:8080")
public interface RestInterface {
    
    @GetExchange(value = "/department/findAll", accept = MediaType.APPLICATION_XML_VALUE)
    List<Department> findAll();
    
    @GetExchange("/{id}")
    Department get(@PathVariable("id") String id);
    
    @PostExchange("/saveJson")
    String saveJson(@RequestBody Department department);
    
    @PostExchange(value = "/", contentType = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    void save(Department department);
}
