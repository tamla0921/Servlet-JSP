<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>pageContext</title>
</head>
<body>
    <%! public void work(String p, PageContext pc) {
        // 선언문으로 멤버변수 또는 메서드 선언하는 선언문 태그
        // 실행은 되지 않으며, 실행을 하려면 실행문이 _jspService() 메서드 내 혹은 _jspService() 메서드 내 호출.
        try {
            JspWriter out = pc.getOut();
            // 선언문 태그는 _jspService() 메서드 밖에 있으므로, 내장 객체를 선언, 초기화해야 함.
            // PageContext에 있는 내장 객체를 이용.
            if (p.equals("include")) {
                out.print("-- include 전 -- <br>");
                pc.include("test.jsp");
                // test.jsp 페이지를 현재 페이지에 포함.
                // include 지시자와 비슷?
                out.print("-- include 후 -- <br>");
            } else if (p.equals("forward")) {
                pc.forward("test.jsp");
                // test.jsp 페이지로 이동.
            }
        } catch (Exception e) {
            System.out.println("오류 발생!!");
        }
    }
    %>
    <%
    String p = request.getParameter("p");
    this.work(p, pageContext);
    // pageContext는 내장 객체!
    %>
</body>
</html>