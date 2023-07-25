<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>덧셈</title>
</head>
<body>
    <h3>선언문으로 구현한 덧셈</h3>
    <%!
    public int sum(int a, int b) {
        return a+b;
    }
    %>
    <%-- 실행과 관련없이 단지 메서드를 선언하는 부분, 실행되려면 _jspSevice() 메서드 내에 있어야 하지만, 선언문 태그는 클래스 멤버로 선언됨. --%>
    
    덧셈의 결과 : <%= this.sum(20,30) %>
    <%-- _jspService() 메서드 내에 코드로 변환. --%>
    <%-- out.write("덧셈의 결과 : "); --%>
    <%-- out.print(this.sum(20, 30); --%>
</body>
</html>