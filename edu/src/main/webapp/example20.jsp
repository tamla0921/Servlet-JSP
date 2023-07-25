<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>EL</title>
</head>
<body>
    <jsp:forward page="${param.p}"  />
    <%-- 태그의 속성에 값을 지정할 때도 EL을 사용할 수 있음. --%>
    <%-- JSP의 스크립트 기반 태그에서는 속성에 값을 지정할 때 정적이 데이터만 줄 수 있지만, --%>
    <%-- XML 기반의 JSP 태그는 속성에 값을 지정할 때 표현식, EL을 사용하여 동적으로 줄 수 있음. --%>
</body>
</html>