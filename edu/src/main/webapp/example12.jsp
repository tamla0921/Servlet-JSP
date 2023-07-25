<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>application</title>
</head>
<body>
    서버명 : <%= application.getServerInfo() %><br/>
    <%-- getServerInfo(): 현재 사용하고 있는 서버의 정보 추출 --%>
    서블릿 버전 : <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %> <br/>
    <%-- getMajorVersion(): 현재 서버가 지원하고 있는 servlet의 Major 버전 추출 --%>
    <%-- getMinorVersion(): 현재 서버가 지원하고 있는 servlet의 Minor 버전 추출 --%>
    <h3>/edu 리스트</h3>
    <%
    java.util.Set<String> list = application.getResourcePaths("/");
    // 타입을 지정할 때는 패키지명을 포함...
    // getResourcePaths(): 인자로 지정한 디렉터리의 목록을 반환.
    if (list != null) {
        Object[] obj = list.toArray();
        // toArray(): list 객체를 배열로 변환하여 반환.
        for (int i = 0 ; i < obj.length ; i++ ){
            out.print(obj[i] + "<br>");
        }
    }
    %>
</body>
</html>