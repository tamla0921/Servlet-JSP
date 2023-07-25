<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="num" value="${95 }" />
점수 <c:out value="${num }" />은

<c:if test="${num > 60 }">
<%-- test: 조건식 --%>
합격입니다.
</c:if>

<br/>

점수 <c:out value="${num }" />은
<c:choose>
<%-- choose는 여러 개의 조건식으로 이루어짐 --%>
    <c:when test="${num >= 90}">A학점입니다.</c:when>
    <c:when test="${num >= 80}">B학점입니다.</c:when>
    <c:when test="${num >= 70}">C학점입니다.</c:when>
    <c:when test="${num >= 60}">D학점입니다.</c:when>
    <c:otherwise>F학점입니다.</c:otherwise>
</c:choose>