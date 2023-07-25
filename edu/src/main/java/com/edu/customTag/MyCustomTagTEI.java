package com.edu.customTag;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;

public class MyCustomTagTEI extends TagExtraInfo {

        @Override
        public boolean isValid(TagData data) {
            // isValid() 메서드는 커스텀 태그 사용 시 자동으로 호출되는 메서드, 커스텀 태그의 유효성 체크.
            // TagData 객체: 현재 커스텀 태그의 속성과 값을 처리하는 객체.
            
            String color = data.getAttributeString("color");
            // color 속성에 지정된 값 추출.
            
            if (color.equals("blue")) {
                return true;
                // 올바르게 사용
            } else {
                return false;
                // 문제 발생
            }
        }
}
