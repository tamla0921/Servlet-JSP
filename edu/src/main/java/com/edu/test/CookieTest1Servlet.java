package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie1")
public class CookieTest1Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            
            Cookie c1 = new Cookie("id", "guest");
            c1.setPath("/");
            // 현재 웹 애플리케이션에 있는 모든 요청에 대하여 클라이언트 쪽의 쿠키가 전송되도록 설정.
            // 즉, 쿠키를 추출할 수 있는 URI는 전체 페이지로 설정.
            resp.addCookie(c1);
            // c1 쿠키를 클라이언트 쪽으로 전송.
            // 유효시간을 지정하지 않았으므로 -1, 브라우저가 종료됨과 동시에 서버가 전송받은 쿠키도 사라짐.
            
            Cookie c2 = new Cookie("code", "0001");
            c2.setMaxAge(60 * 60 * 3);
            c2.setPath("/");
            resp.addCookie(c2);
            
            Cookie c3 = new Cookie("subject", "java");
            c3.setMaxAge(60 * 60 * 24 * 10);
            c3.setPath("/");
            resp.addCookie(c3);
            
            out.println("쿠키 전송 완료");
            out.close();
    }
} // 클래스 닫음.
