package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int i = 1;
        while (i <= 10) {
            out.print("<br>number : " + i);
            i++;

            try {
                Thread.sleep(100);
                // Thread.sleep() 메서드는 예외(exception)를 던지기(throws) 때문에 try-catch로 처리해줘야 함.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        out.print("<br>실행완료!");
        out.close();
    }
} // 클래스 닫음.
