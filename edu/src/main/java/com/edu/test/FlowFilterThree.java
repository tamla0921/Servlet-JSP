package com.edu.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 필터의 이름을 timer로 지정, 클라이언트로부터 요청이 /third로 들어왔을 때 실행될 필터임을 설정.
@WebFilter(filterName = "timer", urlPatterns="/third")
public class FlowFilterThree implements Filter{

    public void init(FilterConfig config) {}
    
    // 클라이언트로부터 /third 요청이 들어왔을 때 실행할 메서드.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        // 메서드가 실행되는 시간을 밀리 초 단위로 반환하는 메서드.
        chain.doFilter(request, response);

        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        
        System.out.println("수행 시간 : " + executeTime + " ms");
    }
    
    public void destroy() {}
} // 클래스 닫음.
