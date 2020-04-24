package com.a2bo.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.a2bo.member.model.vo.Member;

import common.JDBCTemplate;

public class MemberDao {
	JDBCTemplate jdbc = JDBCTemplate.getInstance();
	
	public MemberDao() {
		super();
	}
	
	public void login() {
		
	}
	
	public int join(Connection conn, Member member) throws SQLException {
		String sql = "insert into tmember values(0, ?, null, null, ?, ?)";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, member.getPw());
			pstm.setString(2, member.getUserEmail());
			pstm.setString(3, member.getNickname());
			
			res = pstm.executeUpdate();
		} finally {
			jdbc.close(pstm);
		}
		
		return res;
	}
	
	public String emailCheck(Connection conn, String email) throws SQLException {
		String res = "";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select useremail from tmember where userEmail = '" + email + "'";
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
