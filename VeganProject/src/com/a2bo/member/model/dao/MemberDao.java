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
	
	public Member login(Connection conn, String email, String pw) throws SQLException {
		String sql = "select * from tmember where useremail='" + email + "' and pw='" + pw + "'";
		Member member = null;
		/*PreparedStatement pstm = null;*/
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				member = new Member();
				member.setUserId(rs.getInt(1));
				member.setPw(rs.getString(2));
				member.setCell(rs.getString(3));
				member.setvLId(rs.getString(4));
				member.setUserEmail(rs.getString(5));
				member.setNickname(rs.getString(6));
			}
		} finally {
			jdbc.close(rs, stmt);
		}
		
		return member;
	}
	
	public int join(Connection conn, Member member) throws SQLException {
		String sql = "insert into tmember values(s_member.nextval, ?, null, null, ?, ?)";
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
	
	public String searchId(Connection conn, String phone, String nickName) throws SQLException {
		String sql = "select useremail from tmember where cell=? and nickName=?";

		ResultSet rs = null;
		String userid = "";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, phone);
			pstm.setString(2, nickName);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				userid = rs.getString(1);
			}
		} finally {
			jdbc.close(rs, pstm);
		}
		
		return userid;
	}
	
	public int searchPw(Connection conn, String userEmail, String nickName) throws SQLException {
		int res = 0;
		String sql = "select * from tmember where userEmail=? and nickName=?";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userEmail);
			pstm.setString(2, nickName);
			
			res = pstm.executeUpdate();
		} finally {
			jdbc.close(pstm);
		}
		
		return res;
	}
	
	public int changePw(Connection conn, String userEmail, String userPw) throws SQLException {
		int res = 0;
		String sql = "update tmember set pw=? where useremail=?";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userPw);
			pstm.setString(2, userEmail);
			
			res = pstm.executeUpdate();
			
		} finally {
			jdbc.close(pstm);
		}
		return res;
	}
}
