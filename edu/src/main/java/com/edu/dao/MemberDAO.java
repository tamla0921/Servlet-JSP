package com.edu.dao;

import java.sql.*;

import com.edu.beans.Member;

public class MemberDAO {

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public void insertMember(Member member) {
        try {
            Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("insert into member values(?, ?, ?, ?)");
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPasswd());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getMail());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
