package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookOutput")
public class BookTest2Servlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        Book book = (Book)req.getAttribute("book");
        
        out.print("<h3>책제목 : " + book.getTitle() + "</h3>");
        out.print("<h3>책저자 : " + book.getAuthor() + "</h3>");
        out.print("<h3>출판사 : " + book.getPublisher() + "</h3>");
        
        out.close();
    }
} // 클래스 닫음.
