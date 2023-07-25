<%@page import="com.edu.biz.MemberService"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
request.setCharacterEncoding("UTF-8");
// POST 방식으로 전달된 파라미터의 값들을 UTF-8로 인코딩.
%>

<jsp:useBean id="member" class="com.edu.beans.Member" />
<jsp:setProperty property="*" name="member" />

<%
MemberService service = new MemberService();
// 회원에 대한 서비스를 처리하는 객체.
service.memberInsert(member);
// 멤버 회원가입 메서드.

RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
rd.forward(request, response);
%>
