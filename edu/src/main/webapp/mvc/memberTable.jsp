<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>

<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

Statement stmt = conn.createStatement();

String sql = "create table member(id varchar2(10) primary key, passwd varchar2(10), name varchar2(10), mail varchar2(20) )";
stmt.executeUpdate(sql);
out.print("member 테이블이 생성되었습니다.");

stmt.close();
conn.close();
%>