package com.linkedbear.springboot.webmvc.l_servietapi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@WebServlet(urlPatterns = "/servlet/demo1")
public class DemoServlet1 extends HttpServlet {
    
    @Autowired
    private DepartmentController103 departmentController103;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("DemoServlet1 doGet run ......");
        System.out.println(departmentController103);
    }
}
