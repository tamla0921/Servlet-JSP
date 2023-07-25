package com.edu.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterTwo implements Filter {

    String charset;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init() 호출 ..... two");
        charset = filterConfig.getInitParameter("en");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding(charset);
        // POST 방식으로 전달되는 질의 문자열은 요청정보의 몸체에 포함되어 전달, 이 데이터들의 인코딩 처리.
        // 이 명령문에 의해 요청정보 몸체에 있는 문자열들이 UTF-8로 인코딩 처리 됨.
        System.out.println("doFilter() 호출 전 ..... two");
        chain.doFilter(request, response);
        // <filter-mapping>에 설정된 값이 flow2 필터 다음에는 없으므로, servlet 실행.
        // servlet을 호출하면서 request, response를 전달. 즉, 현재 객체가 사용하던 HttpServletRequest, HttpServletResponse 객체를 그대로 전달.
        // HttpServletRequest 객체는 요청정보를 처리하는 객체로서 이미 req.setCharacterEncoding("UTF-8")' 명령문에 의해
        // 요청정보 몸체의 문자열들은 인코딩 처리됨.
        // 따라서 servlet 쪽에서 별도로 인코딩 처리를 하지 않아도 됨.
        System.out.println("doFilter() 호출 후 ..... two");
    }
    
    @Override
    public void destroy() {
        System.out.println("destroy() 호출 ..... two");
    }
} // 클래스 닫음.

