package com.edu.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/portalSite")
public class SendRedirectTestServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("site");
        if (param.equals("naver")) {
            resp.sendRedirect("http://www.naver.com");
            // 인자로 지정된 URL로 페이지를 이동하는 명령문으로서 대상이 현재 서버의 자원이 아니어도 상관없음.
        } else if (param.equals("daum")) {
            resp.sendRedirect("http://www.daum.net");
        } else if (param.equals("zum")) {
            resp.sendRedirect("http://www.zum.com");
        } else if (param.equals("google")) {
            resp.sendRedirect("http://www.google.com");
        }
    }
} // 클래스 닫음.
