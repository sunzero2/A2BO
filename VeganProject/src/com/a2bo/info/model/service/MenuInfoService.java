package com.a2bo.info.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.a2bo.info.model.dao.MenuInfoDao;
import com.a2bo.info.model.vo.Review;

import common.JDBCTemplate;

public class MenuInfoService {
	private JDBCTemplate jdbc = JDBCTemplate.getInstance();
	private MenuInfoDao mDao = new MenuInfoDao();
	
	public List<Review> getReview(String menuId) {
		List<Review> list = null;
		Connection conn = jdbc.getConnection();
		try {
			list = mDao.getReview(conn, menuId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int addReview(int userId, String menuId, String content, int star) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res = mDao.addReview(conn, userId, menuId, content, star);
			jdbc.commit(conn);
		} catch (SQLException e) {
			jdbc.rollback(conn);
			e.printStackTrace();
		}
		return res;
	}
}
