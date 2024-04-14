package com.linkedbear.spring00.d_properties.servlet;

import com.linkedbear.spring00.d_properties.factory.BeanFactory;
import com.linkedbear.spring00.d_properties.service.DemoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo4")
public class DemoServlet4 extends HttpServlet {
    
    DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}
