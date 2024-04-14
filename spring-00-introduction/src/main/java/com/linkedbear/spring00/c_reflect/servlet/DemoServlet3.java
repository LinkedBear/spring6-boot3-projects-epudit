package com.linkedbear.spring00.c_reflect.servlet;

import com.linkedbear.spring00.c_reflect.factory.BeanFactory;
import com.linkedbear.spring00.c_reflect.service.DemoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo3")
public class DemoServlet3 extends HttpServlet {
    
    DemoService demoService = BeanFactory.getDemoService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}
