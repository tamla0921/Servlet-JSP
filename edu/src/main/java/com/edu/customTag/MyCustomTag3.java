package com.edu.customTag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyCustomTag3 extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = this.getJspContext();
        // SimpleTagSupport 객체에서 제공하는 getJspContext()
        // JspContext 객체 반환해주는 메서드.
        //  ㄴ JSP 페이지에 대한 정보를 가지는 객체.
        
        JspWriter out = context.getOut();
        // 현재 JSP 페이지와 서비스를 요청한 클라이언트 간에 연결된 출력스트림인 JspWriter를 추출하여 반환하는 메서드.
        
        JspFragment body = this.getJspBody();
        // 커스텀 태그의 몸체를 처리하는 JspFragment 객체를 추출하는 메서드.
        
        StringWriter sw = new StringWriter();
        // StringWriter 객체는 문자열을 String 버퍼에 출력.
        body.invoke(sw);
        // invoke(): 커스텀 태그의 몸체를 추출.
        // 추출된 커스텀 태그의 몸체를 sw에 출력.
        
        String str = sw.toString();
        out.print(str.toUpperCase());
        return;
    }
}
