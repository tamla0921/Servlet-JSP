package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookReg")
public class BookTest1Servlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        req.setCharacterEncoding("UTF-8");
        // 질의 문자열들은 POST 방식으로 요청함.
        // 요청정보의 몸체에 포함되어 전달.
        // 한글을 처리하기 위한 부분으로 UTF-8 문자코드를 이용하여 인코딩 처리.
        
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        
        req.setAttribute("book", book);
        // ServletContext... HttpServletRequest 객체에 다른 페이지에서 사용하기 위해 "book" 이름으로 book 변수의 값을 저장.
        
        RequestDispatcher rd = req.getRequestDispatcher("bookOutput");
        rd.forward(req, resp);
    }
} // 클래스 닫음.
