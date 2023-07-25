<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>example</title>
</head>
<body>
    <jsp:useBean id="book" class="com.edu.beans.BookBean"/>
    <%-- BookBean 객체 생성, 메모리에는 BookBean의 멤버변수가 만들어지고(head 영역), 생성된 객체의 시작 주솟값은 book 변수가 참조(stack 영역) --%>
    <jsp:setProperty property="*" name="book" />
    <%--  --%>
    
    <%
    application.setAttribute("book", book);
    // ServletContext 객체에 "book"이란 이름으로 변수 book의 값을 등록!
    %>
    
    <jsp:forward page="bookOutput.jsp" />
    <%-- 이동할 때 현재 페이지에서 사용했던 HttpServletRequest 객체의 주솟값이 그대로 bookOutput.jsp로 전달. --%>
    <%-- 전달되는 request 객체에는 "book"이란 이름으로 BookBean 객체가 등록된 상태. --%>
</body>
</html>