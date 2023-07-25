<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page errorPage="example3.jsp" %>
<%-- 오류가 발생할 경우, 해당 오류를 처리할 페이지 지정. 프로그램이 강제로 중단되지 않게 할 수 있음. --%>
<%
String param = request.getParameter("id");
if (param.equals("test"))
    param = "파라미터가 입력되었습니다. (예외 상황이 발생하지 않았습니다.)";
%>

<%-- id라는 질의 문자열이 없을 경우 param은 null --%>
<%-- param.equals("test")에서 NullPointerException 발생, 에러페이지로 이동. --%>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>