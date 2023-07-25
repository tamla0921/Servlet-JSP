package com.edu.customTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyCustomTag2 extends SimpleTagSupport {
    // JSP 2.0 이상의 버전으로 커스텀 태그를 작성할 때 SimpleTagSupport 객체 상속.

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("커스텀 태그의 바디가 실행되기 전");
        for (int i = 0 ; i < 10 ; i++) {
            getJspBody().invoke(null);
            // 커스텀 태그의 몸체를 출력하는 명령문.
        }
        System.out.println("커스텀 태그의 바디가 실행된 후");
    }
}
