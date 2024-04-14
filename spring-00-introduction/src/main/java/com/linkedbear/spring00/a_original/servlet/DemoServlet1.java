package com.linkedbear.spring00.a_original.servlet;

import com.linkedbear.spring00.a_original.service.DemoService;
import com.linkedbear.spring00.a_original.service.impl.DemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/demo1")
public class DemoServlet1 extends HttpServlet {
    
    DemoService demoService = new DemoServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
    }
}
