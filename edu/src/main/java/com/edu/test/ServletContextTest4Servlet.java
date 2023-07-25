package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context4")
public class ServletContextTest4Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html;charset=UTF-8");
       PrintWriter out = resp.getWriter();
       
       ServletContext sc = this.getServletContext();
       // ServletContextTest3Servlet와 ServletContextTest4Servlet는 동일한 웹 애플리케이션이므로 반환되는 ServletContext 객체는 동일함.
       
       ShareObject obj1 = (ShareObject) sc.getAttribute("data1");
       ShareObject obj2 = (ShareObject) sc.getAttribute("data2");
       
       out.print("DATA 1 : " + obj1.getCount() + ", " + obj1.getStr() + "<br>");
       out.print("DATA 2 : " + obj2.getCount() + ", " + obj2.getStr() + "<br>");
       
       out.close();
    }
} // 클래스 닫음.
