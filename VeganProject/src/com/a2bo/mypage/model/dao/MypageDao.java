package com.a2bo.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.a2bo.info.model.vo.Review;
import com.a2bo.member.model.vo.Member;

import common.JDBCTemplate;

public class MypageDao {
	JDBCTemplate jdbc = JDBCTemplate.getInstance();
	
	public MypageDao() {
		super();
	}
	
	public int changeVL(Connection conn, String vl, int userId) throws SQLException {
		String sql = "update tmember set vlid=? where userid=?";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vl);
			pstm.setInt(2, userId);
			res = pstm.executeUpdate();
		} finally {
			jdbc.close(pstm);
		}
		return res;
	}
	
	public int changeMember(Connection conn, String nickname, String pw, String cell) throws SQLException {
		String sql = "update tmember set nickname=?, pw=?, cell=?";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nickname);
			pstm.setString(2, pw);
			pstm.setString(3, cell);
			
			res = pstm.executeUpdate();
		} finally {
			jdbc.close(pstm);
		}
		
		return res;
	}
	
	public List<Review> myReview(Connection conn, int userId) throws SQLException {
		List<Review> list = new ArrayList<Review>();
		Review review = null;
		String sql = "select * from treview r inner join tmember m using(userid) where userid=" + userId;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				review = new Review();
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
	
	public int delReview(Connection conn, String revId) throws SQLException {
		int res = 0;
		String sql = "delete from treview where revid = '" + revId + "'";
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
		} finally {
			jdbc.close(stmt);
		}
		return res;
	}
	
	public int chgReview(Connection conn, String revId, String cont) throws SQLException {
		int res = 0;
		String sql = "update treview set revcontent = '" + cont + "' where revid = '"+ revId + "'";
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
		} finally {
			jdbc.close(stmt);
		}
		return res;
	}
}
