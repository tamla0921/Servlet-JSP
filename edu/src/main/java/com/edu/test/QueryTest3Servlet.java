package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest3")
public class QueryTest3Servlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Query 문자열 테스트</title></head>");
        out.print("<body>");
        out.print("<h1>GET 방식으로 요청되었습니다.</h1>");
        
        String name = req.getParameter("name");
        out.print("이름 : " + name + "<br/>");
        out.print("</body></html>");
        out.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Query 문자열 테스트</title></head>");
        out.print("<body>");
        out.print("<h1>POST 방식으로 요청되었습니다.</h1>");
        
        req.setCharacterEncoding("UTF-8");
        // 인자값으로 지정된 문자코드를 사용하여 클라이언트가 전달한 요청정보 몸체에 있는 문자열들을 인코딩해주는 메서드.
        // setCharacterEncoding() 메서드로 인코딩 작업을 처리 후 getParameter() 메서드로 추출하여 사용.
        String name = req.getParameter("name");
        out.print("이름 : " + name + "<br/>");
        out.print("</body></html>");
        out.close();
    }
} // 클래스 닫음.
