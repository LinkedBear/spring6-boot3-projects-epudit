package com.linkedbear.spring00.b_factory.servlet;

import com.linkedbear.spring00.b_factory.factory.BeanFactory;
import com.linkedbear.spring00.b_factory.service.DemoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2")
public class DemoServlet2 extends HttpServlet {
    
    DemoService demoService = BeanFactory.getDemoService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}
