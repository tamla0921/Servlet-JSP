package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher1")
public class DispatcherTest1Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<h3> Dispatcher Test1의 수행 결과 </h3>");
        
        ServletContext sc = this.getServletContext();
        // ServletContext에서 제공하는 RequestDispatcher 객체를 생성하는 메서드를 사용하기 위해.
        RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");
        // "/dispatcher2"라는 path 값을 가진 RequestDispatcher 객체 생성.
        rd.include(req, resp);
        // rd 객체가 가지고 있는 path에 해당하는 페이지로 이동.
        // 이동한 페이지에서 클라이언트 측으로 응답을 보냄.
        // 현재 페이지가 사용하는 req, resp 인자는 이동할 페이지로 그대로 전달
        // 즉, 이동할 페이지에서 사용하는 HttpServletRequest, HttpServletResponse 객체는 forward() 메서드에서 전달한 객체!
        out.print("test");
        // 그러나 이것은... 작동되지 않네?
        out.close();
    }
} // 클래스 닫음.
