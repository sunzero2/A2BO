package com.a2bo.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.a2bo.member.model.dao.MemberDao;
import com.a2bo.member.model.vo.Member;

import common.JDBCTemplate;

public class MemberService {
	JDBCTemplate jdbc = JDBCTemplate.getInstance();
	MemberDao mDao = new MemberDao();
	
	public MemberService() {
		super();
	}
	
	public Member login(String email, String pw) {
		Member member = null;
		Connection conn = jdbc.getConnection();
		try {
			member = mDao.login(conn, email, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		
		return member;
	}
	
	public int join(Member member) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res = mDao.join(conn, member);
			System.out.println("service : " + res);
			jdbc.commit(conn);
		} catch (SQLException e) {
			jdbc.rollback(conn);
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}
	
	public String emailCheck(String email) {
		String res = "";
		Connection conn = jdbc.getConnection();
		try {
			res = mDao.emailCheck(conn, email);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}
	
	public String searchID(String phone, String nickName) {
		String userEmail = "";
		Connection conn = jdbc.getConnection();
		
		try {
			userEmail = mDao.searchId(conn, phone, nickName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		
		return userEmail;
	}
	
	public int searchPw(String userEmail, String nickName) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		
		try {
			res = mDao.searchPw(conn, userEmail, nickName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		
		return res;
	}
	
	public int changePw(String userEmail, String userPw) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		
		try {
			res = mDao.changePw(conn, userEmail, userPw);
			jdbc.commit(conn);
		} catch (SQLException e) {
			jdbc.rollback(conn);
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}
}
