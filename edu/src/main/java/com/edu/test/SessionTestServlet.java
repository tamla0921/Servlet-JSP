package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {

        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            String param = req.getParameter("p");
            // 클라이언트로부터 전달된 질의 문자열 중에서 p 값을 추출.
            // GET 방식이므로 질의 문자열을 URL에 적을 수 있음.
            String msg = null;
            // 처리가 끝난 후 브라우저에 출력할 문자열.
            HttpSession session = null;
            // HttpSession 주솟값.
            
            if (param.equals("create")) {
                session = req.getSession();
                if (session.isNew()) {
                    msg = "새로운 세션 객체가 생성됨";
                } else {
                    msg = "기존의 세션 객체가 리턴됨";
                }
            } else if (param.equals("delete")) {
                session = req.getSession(false);
                // 세션이 존재하지 않았으면 null을 반환, 세션이 존재할 경우 그대로 반환?
                if (session != null) {
                    session.invalidate();
                    msg = "세션 객체 삭제 작업 완료";
                } else {
                    msg = "삭제할 세션 존재하지 않음";
                }
            } else if (param.equals("add")) {
                session = req.getSession(true);
                session.setAttribute("msg", "메시지입니다");
                // "메시지입니다"라는 문자열을 "msg" 이름으로 세션 객체에 등록.
                msg = "세션 객체에 데이터 등록 완료";
            } else if (param.equals("get")) {
                session = req.getSession(false);
                // 세션이 존재하지 않을 경우 null을 반환, 세션이 존재할 경우 그대로 반환.
                if (session != null) {
                    String str = (String) session.getAttribute("msg");
                    // getAttribute는 Object 타입을 반환 -> 캐스팅을 해야 함.
                    msg = str;
                } else {
                    msg = "데이터를 추출할 세션 객체 존재하지 않음";
                }
            } else if (param.equals("remove")) {
                session = req.getSession(false);
                // 세션이 존재하지 않을 경우 null을 반환, 세션이 존재할 경우 그대로 반환.
                if (session != null) {
                    session.removeAttribute("msg");
                    msg = "세션 객체의 데이터 삭제 완료";
                } else {
                    msg = "데이터를 삭제할 세션 객체 존재하지 않음";
                }
            } else if (param.equals("replace")) {
                session = req.getSession();
                session.setAttribute("msg", "새로운 메시지입니다");
                msg = "세션 객체에 데이터 등록 완료";
            }
            
            out.print("처리 결과 : " + msg);
            out.close();
        }
} // 클래스 닫음.
