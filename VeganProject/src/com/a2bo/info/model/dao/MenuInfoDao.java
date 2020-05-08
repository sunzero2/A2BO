package com.a2bo.info.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.a2bo.info.model.vo.Review;

import common.JDBCTemplate;

public class MenuInfoDao {
	private JDBCTemplate jdbc = JDBCTemplate.getInstance();
	public MenuInfoDao() {
	}
	
	public List<Review> getReview(Connection conn, String menuId) throws SQLException {
		List<Review> list = new ArrayList<Review>();
		String sql = "select * from treview inner join tmember using(userid) where menuid = '" + menuId + "'";
		Statement stmt = null;
		ResultSet rs = null;
		Review review = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				review = new Review();
				review.setUserId(rs.getInt(1));
				review.setRevId(rs.getInt(2));
				review.setRevDate(rs.getDate(4));
				review.setRevContent(rs.getString(5));
				review.setRevStar(rs.getInt(6));
				review.setMenuId(rs.getString(7));
				review.setNickName(rs.getString(14));
				
				list.add(review);
			}
		} finally {
			jdbc.close(rs, stmt);
		}
		return list;
	}
	
	public int addReview(Connection conn, int userId, String menuId, String content, int star) throws SQLException {
		int res = 0;
		// userid, cont, star, menuid
		String sql = "insert into treview values(s_review.nextval, null, ?, sysdate, ?, ?, ?, null, null)";
		
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			pstm.setString(2, content);
			pstm.setInt(3, star);
			pstm.setString(4, menuId);
			
			res = pstm.executeUpdate();
		} finally {
			jdbc.close(pstm);
		}
		
		return res;
	}
}
