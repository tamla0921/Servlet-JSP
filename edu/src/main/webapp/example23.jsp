<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="my" uri="http://myTags.com" %>
<%-- JSP 페이지에서 커스텀 태그를 사용하기 위해 선언하는 지시자 --%>

<%-- prefix는 선언된 태그 라이브러리에 이름을 지정하는 속성으로, 사용자 임의 지정,  --%>
<%-- 태그 이름이 중복될 수 있으므로, 혼란을 방지하고자 작성 --%>
<%-- <태그 라이브러리 이름:태그 이름> 형식으로 사용. --%>

<%-- uri에는 web.xml에 등록한 <taglib-uri> 지정하면 태그 라이브러리에 등록된 커스텀 태그 사용할 수 있음. --%>
<html>
<head>
<title>Custom Tag</title>
</head>
<body>
<my:first color="blue"><%= 1+2 %></my:first>

Custom Tag Test!
</body>
</html>