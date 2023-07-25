package com.edu.customTag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyCustomTag4 extends SimpleTagSupport {

    private int num1;
    private int num2;
    
    public int getNum1() {
        return num1;
    }
    
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    
    public int getNum2() {
        return num2;
    }
    
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = this.getJspContext();
        // (1) JstContext 객체를 얻음.
        JspWriter out = context.getOut();
        // (2) JspContext 객체에서 클라이언트와 연결된 출력스트림 out을 얻음.
        out.print(num1 + "+" + num2 + "=" + (num1 + num2));
    }
}
