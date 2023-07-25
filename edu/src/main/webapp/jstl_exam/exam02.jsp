<%@ page import="com.edu.beans.BookBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% BookBean book = new BookBean(); %>

<c:set target="<%= book %>" property="title" value="The Secret" />
<%-- target: setter 메서드를 호출할 자바 객체 지정. --%>
<%-- property: 값을 변경할 자바 객체의 멤버변수 이름을 지정. --%>
<%= book.getTitle() %> <br/>

<c:set var="b" value="<%= book %>" />
<c:set target="${b}" property="author" value="Byrne, Rhonda" />
${b.author}