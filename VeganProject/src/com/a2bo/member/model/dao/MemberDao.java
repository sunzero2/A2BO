package com.a2bo.member.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.JDBCTemplate;

public class MemberDao {
	JDBCTemplate jdbc = JDBCTemplate.getInstance();
	
	public MemberDao() {
		super();
	}
	
	public void login() {
		
	}
	
	public void join() {
		
	}
	
	public String emailCheck(Connection conn, String email) throws SQLException {
		String res = "";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select userid from tmember where userid = '" + email + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				res = rs.getString(1);
			}			
		} finally {
			jdbc.close(rs, stmt);
		}
		return res;
	}
}
