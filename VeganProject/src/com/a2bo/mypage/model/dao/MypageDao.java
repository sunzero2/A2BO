package com.a2bo.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.a2bo.member.model.vo.Member;

import common.JDBCTemplate;

public class MypageDao {
	JDBCTemplate jdbc = JDBCTemplate.getInstance();
	
	public MypageDao() {
		super();
	}
	
	public void likeMenuList() {
		
	}
	
	public void removeLikeMenu() {
		
	}
	
	public void changeVL() {
		
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
}
