package com.edu.customTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyCustomTag extends TagSupport {
    int cnt = 1;
    
    private String color;
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public int doStartTag() throws JspException {
        // JSP 태그의 시작 태그를 만나면 자동으로 호출.
        System.out.println("시작태그를 만났습니다.");
        System.out.println("color 속성 값 : " + color);
        return EVAL_BODY_INCLUDE;
        // 메서드가 종료된 후 태그의 몸체를 처리하는 역할.
    }
    
    @Override
    public int doAfterBody() throws JspException {
        System.out.println("body 처리가 끝났습니다. : " + cnt);
        
        return SKIP_BODY;
        // SKIP_BODY 처리했으므로, 커스텀 태그의 몸체는 한 번만 처리.
        
    }
    
    @Override
    public int doEndTag() throws JspException {
        // JSP 태그의 끝 태그를 만나면 자동으로 호출.
        System.out.println("끝태그를 만났습니다.");
        return EVAL_PAGE;
    }
}
