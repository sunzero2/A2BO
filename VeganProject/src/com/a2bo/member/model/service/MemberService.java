package com.a2bo.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.a2bo.member.model.dao.MemberDao;

import common.JDBCTemplate;

public class MemberService {
	JDBCTemplate jdbc = JDBCTemplate.getInstance();
	MemberDao mDao = new MemberDao();
	
	public MemberService() {
		super();
	}
	
	public void login() {
		
	}
	
	public void join() {
		
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
}
