<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%-- 일반 데이터 베이스 작업 --%>
<%@ page import="javax.sql.*" %>
<%-- DataSource 객체 사용 --%>
<%@ page import="javax.naming.*" %>
<%-- JNDI 작업용 --%>

<%
// 1. JDNI 서버 객체 생성
InitialContext ic = new InitialContext();
// JNDI 서버 역할을 하는 객체 생성.
// 리소스가 로컬에 있을 때는 단순히 InitialContext 객체만 생성.

// Connection Pool에 접근하려면 JNDI 서비스 사용.
// JNDI: 서버에서 관리하고 있는 리소스에 대한 정보를 알고 있고 특정 리소스를 찾아서 사용할 수 있도록 객체를 반환해주는 역할.


// 2. lookup()
DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
// ic.lookup()
//  리소스를 찾은 후 리소스를 사용할 수 있도록 객체를 반환해주는 메서드.
//  인자값으로 찾으려는 리소스의 등록된 이름 지정.
//      WAS로 톰캣을 이용하는데, 톰캣에서는 리소스를 관리하는 가상의 디렉터리의 경로가 "java:comp/env" 임.
//      톰캣을 사용할 때는 리소스 이름 앞에 java:comp/env의 경로 지정.
//  Object 타입을 반환하므로, 원래 리소스 타입으로 강제 타입 변환.
//  DataSource 객체는 Connection Pool 리소스의 데이터 타입.

// 3. getConnection()
Connection conn = ds.getConnection();
// Connection Pool에 준비된 Connection 객체를 빌려옴. 

Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from test");

while (rs.next()) {
    out.print("<br>" + rs.getString("id") + ":" + rs.getString(2));
}

rs.close();
stmt.close();
conn.close(); // 반납
%>