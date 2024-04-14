package com.linkedbear.spring00.e_cachedfactory.servlet;

import com.linkedbear.spring00.e_cachedfactory.factory.BeanFactory;
import com.linkedbear.spring00.e_cachedfactory.service.DemoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo5")
public class DemoServlet5 extends HttpServlet {
    
    DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}
