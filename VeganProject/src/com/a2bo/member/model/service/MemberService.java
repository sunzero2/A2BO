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
	
	public void login() {
		
	}
	
	public int join(Member member) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res = mDao.join(conn, member);
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
}
