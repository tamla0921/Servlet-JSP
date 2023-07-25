package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie3")
public class CookieTest3Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        int cnt = 0;
        Cookie[] list = req.getCookies();
        for (int i = 0 ; list != null && i < list.length ; i++) {
            if(list[i].getName().equals("count")) {
                cnt = Integer.parseInt(list[i].getValue());
                // 웹서버와 관련된 것들은 대부분 String인 것 같다.
            }
        }
        
        cnt++;
        
        Cookie c = new Cookie("count", cnt+"");
        // Cookie(String, String)에서 int 타입인 cnt를 String 타입으로 바꾸기 위해서
        // int + String = String이 되는 것을 이용.
        c.setMaxAge(60*60*24*10);
        
        resp.addCookie(c);
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<h1>방문 횟수 : "+ cnt);
        out.close();
    } // 메서드 닫음.
} // 클래스 닫음.
