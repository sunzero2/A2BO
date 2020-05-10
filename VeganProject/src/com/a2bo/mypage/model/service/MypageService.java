package com.a2bo.mypage.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.a2bo.info.model.vo.Review;
import com.a2bo.member.model.vo.Member;
import com.a2bo.mypage.model.dao.MypageDao;

import common.JDBCTemplate;

public class MypageService {
	private JDBCTemplate jdbc = JDBCTemplate.getInstance();
	private MypageDao mDao = new MypageDao();

	public MypageService() {
		super();
	}

	public int changeVL(String vl, int userId) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res = mDao.changeVL(conn, vl, userId);
			jdbc.commit(conn);
		} catch (SQLException e) {
			jdbc.rollback(conn);
			e.printStackTrace();
		}
		return res;
	}

	public int changeMember(String nickname, String pw, String cell) {
		int res = 0;
		Connection conn = jdbc.getConnection();

		try {
			res = mDao.changeMember(conn, nickname, pw, cell);
			jdbc.commit(conn);
		} catch (SQLException e) {
			jdbc.rollback(conn);
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}
	
	public List<Review> myReview(int userId) {
		List<Review> list = null;
		Connection conn = jdbc.getConnection();
		
		try {
			list = mDao.myReview(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		
		return list;
	}
	
	public int delReview(String revId) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		
		try {
			res = mDao.delReview(conn, revId);
			jdbc.commit(conn);
		} catch (SQLException e) {
			jdbc.rollback(conn);
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}
	
	public int chgReview(String revId, String cont) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		
		try {
			res = mDao.chgReview(conn, revId, cont);
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
