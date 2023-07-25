package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        String env = this.getInitParameter("charset");
        // web.xml 파일에서 <init-param>으로 지정한 변수 중, "charset"이란 이름으로 설정된 <param-name>을 찾음.
        
        
        req.setCharacterEncoding(env);
        // 큰따옴표로 직접 값을 지정할 경우,
        // 시스템 개발이 끝난 이후 값을 수정할 일이 발생한다면 소스를 직접 수정한 다음 다시 컴파일하여 서버에 클래스 파일을 다시 올려야 함.
        // 외부에 값을 지정한 다음 추출할 경우, <param-value> 태그의 값만 변경하면 수정작업이 완료.
        // 유지보수 측면에서 훨씬 더 효율적.
        out.print("<h3> 이름 : " +req.getParameter("name")+ "</h3>");
        out.close();
    }
} // 클래스 닫음.
