package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocalTestServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int number = 0;
            String str = req.getParameter("msg");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            
            out.println("<html><head><title>MultiThread Test</title></head>");
            out.println("<body><h2>처리 결과(지역 변수)</h2>");
            while (number++ < 10) {
                out.print(str + " : " + number + "<br>");
                out.flush();
                // out 출력스트림의 버퍼에 있는 내용을 강제 전송
                // 기본적으로는 버퍼의 크기만큼 내용이 채워졌을 때 실제 전송이 이뤄짐.
                // flush() 메서드는 버퍼가 채워졌는지와 상관없이 버퍼에 있는 내용을 출력해줌.
                System.out.println(str + " : " + number);
                
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            out.println("<h2>Done : " + str + " !!</h2>");
            out.println("</body></html>");
            out.close();
        }
} // 클래스 닫음.
