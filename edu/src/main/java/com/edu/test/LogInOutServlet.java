package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet {

    // 로그인 처리
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html;charset=UTF-8");
         PrintWriter out = resp.getWriter();
         
         String id = req.getParameter("id");
         String pwd = req.getParameter("pwd");
         
         if (id.isEmpty() || pwd.isEmpty()) {
             out.print("ID 또는 비밀번호를 입력해주세요. ");
             return;
         }
         HttpSession session = req.getSession();
         if (session.isNew() || session.getAttribute("id") == null ) {
             session.setAttribute("id", id);
            // 로그인 작업은 세션 객체에 특정 데이터를 등록하는 것!
             out.print("로그인을 완료하였습니다.");
         } else {
             out.print("현재 로그인 상태입니다.");
         }
    } // doPost 메서드 닫음.
    
    // 로그아웃 처리
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        
        if (session != null && session.getAttribute("id") != null) {
            session.invalidate();
            // 세션 객체를 삭제하는 메서드.
            out.print("로그아웃 작업 완료하였습니다.");
        } else {
            out.print("현재 로그인 상태가 아닙니다.");
        }
        out.close(); // ?
    } // doGet 메서드 닫음.
} // 클래스 닫음.
