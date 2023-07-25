<%@ page import="com.edu.beans.BookBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="name" value="Amy" />
<c:out value="${name}" /><br/>

<%
BookBean book = new BookBean("The Secret", "Byrne, Rhonda", "Atria Books");
request.setAttribute("bookOne", book);
%>

<c:set var="title" value="${bookOne.title}" />
<c:out value="${title}" /><br/>

<c:set var="author" value="<%=book.getAuthor() %>" />
<c:out value="${author }" /><br/>

<hr>

<c:set var="name">Tobey</c:set>
<c:out value="${name }" /><br>

<%
BookBean book2 = new BookBean("The Last Lecture", "Randy Pausch", "hyperion");
request.setAttribute("bookTwo", book2);
%>

<c:set var="title">${bookTwo.title}</c:set>
<c:out value="${title}"/><br/>

<c:set var="author"><%=book2.getAuthor() %></c:set>
<c:out value="${author}" /><br/>


<!-- c:set 태그는 문자열, EL, 표현식을 쓸 수 있다. -->
<!-- 값은 value 태그를 달거나 태그의 몸체에 쓸 수 있다. -->