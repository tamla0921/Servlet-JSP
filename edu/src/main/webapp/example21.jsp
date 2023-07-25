<%@ page contentType="text/html; charset=UTF-8" import="java.util.*" %>
<html>
<head>
<title></title>
</head>
<body>
    <%
    Enumeration<String> list = request.getHeaderNames();
    // 요청정보의 헤더에서 헤더정보의 이름들만 추출하여 반환하는 메서드.
    while (list.hasMoreElements()) {
        String key = list.nextElement();
        // 커서 다음에 위치한 값을 반환하며 커서를 다음 데이터로 이동.
        out.print("<br>" + key + " : " + request.getHeader(key));
        // key 변수에 저장된 헤더의 이름에 매핑된 값 추출.
    }
    %>
    
    <hr>
    ${header}
    <%-- 위 스크립트릿과 동일한 값을 가져오는 EL 내장 객체 --%>
</body>
</html>