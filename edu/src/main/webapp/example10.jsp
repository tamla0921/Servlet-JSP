<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head><title>Result</title></head>
<body>

<% if(request.getMethod().equals("POST")) { %>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

// 유효성 체크
if (id.isEmpty() || pwd.isEmpty()) {
    request.setAttribute("error", "ID 또는 비밀번호를 입력해주세요!");
    RequestDispatcher rd = request.getRequestDispatcher("logInOut.jsp");
    rd.forward(request, response);
    return;
}

// 로그인 처리
if (session.isNew() || session.getAttribute("id") == null) {
    // session 변수가 초기화될 때 HttpSession 객체가 새로 생성돼서 반환될 수도 있고, 기존에 존재하던 HttpSession 객체가 반환될 수도 있음.
    // isNew() 메서드가 true를 반환할 시, HttpSession 객체를 새로 생성해서 반환한 것이므로 기존에 로그인 상태가 아니라는 의미.
    session.setAttribute("id", id);
    // 로그인 처리 작업
    out.print("로그인 작업이 완료되었습니다.");
} else {
    out.print("이미 로그인 상태입니다.");
}
%>

<%= id %> / <%= pwd %>

<% } else if(request.getMethod().equals("GET")) {
    if (session != null && session.getAttribute("id") != null) {
    // 예제의 로그인 상태는 HttpSession이 존재하고, HttpSession에 "id"가 등록된 상태를 의미
    
        session.invalidate();
        // HttpSession 객체를 삭제하는 메서드.
        out.print("로그아웃 작업이 완료되었습니다.");
    } else {
        out.print("현재 로그인 상태가 아닙니다.");
    }
}
%>
<%
RequestDispatcher rd = request.getRequestDispatcher("logInOut.jsp");
rd.forward(request, response);
%>
</body>
</html>