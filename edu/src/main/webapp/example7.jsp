<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>구구단</title>
</head>
<body>
    <h3>스크립트릿으로 구구단 출력</h3>
    <%
    for(int i=2 ; i < 10 ; i++) {
        for(int j=1 ; j < 10; j++) {
            out.print(i+"*"+j+"="+(i*j)); %> <br>
        <% } %> <br>
    <% } %>
    <%-- JSP 페이지 작성 시 JSP 태그 안에 또 다른 태그를 사용할 수 없음. --%>
    <%-- 그렇기 때문에 HTML <br> 태그를 사용하기 위해 사용하기 전에 JSP 스크립트릿 태그를 닫음.... --%>
    <%-- 중첩 태그를 허용하지 않으므로 간단한 구현조차도 매번 태그를 열고 닫고해야 하기 때문에 가독성이 떨어짐. --%>
    
    <h3> 구구단출력 2</h3>
    <%
    for(int i=2 ; i < 10 ; i++) {
        for (int j=1 ; j < 10; j++) {
            out.println(i+"*"+j+"="+(i*j));
        }
        out.println();
    }
    %>
</body>
</html>