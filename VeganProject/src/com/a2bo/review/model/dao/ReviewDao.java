package com.a2bo.review.model.dao;

/*import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.a2bo.review.model.vo.review;
import common.JDBCTemplate;
import common.util.Paging;
import vg.review.model.vo.Review;

public class ReviewDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public ReviewDao() {
		
	}
	
	public List<Review> myReviews(Connection conn, Member id) throws SQLException {
		
		List<Review> rlist = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		String sql = "select * from treview where userid = ?";
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				Review myRevs=new Review();
				myRevs.setReviewNo(rs.getInt(1));
				myRevs.setReviewTitle(rs.getString(2));
				myRevs.setReviewWriter(rs.getString(3));
				myRevs.setReviewDate(rs.getDate(4));	
				myRevs.setReviewContent(rs.getString(5));
				myRevs.setReviewStar(rs.getInt(6));
				myRevs.setMenuId(rs.getString(7));
				myRevs.setOriginal_filepath(rs.getString(8));
				myRevs.setRename_filepath(rs.getString(9));
			
				rlist.add(myRevs);
			}
			
		}finally {
			jdt.close(rs,pstmt);
		}
		return rlist;
	}
	
	//review upload method service에서 커밋해줄것.
	
		public int reviewUpload(Connection conn, Review review) throws SQLException {
			
		int res = 0;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		String sql = "insert into treview values(s_notice.nextval,?,?,sysdate,?,?,?,?,?)";
		try {
		pstm = conn.prepareStatement(sql);
		if(rs.next()) {
			Review myRevs=new Review();
			
			myRevs.setReviewTitle(rs.getString(2));
			myRevs.setReviewWriter(rs.getString(3));
			myRevs.setReviewContent(rs.getString(5));
			myRevs.setReviewStar(rs.getInt(6));
			myRevs.setMenuId(rs.getString(7));
			myRevs.setOriginal_filepath(rs.getString(8));
			myRevs.setRename_filepath(rs.getString(9));
		
		}
		res=pstm.executeUpdate();
		}finally {
			jdt.close(pstm);
		}
		return res;
		}
		
		//리뷰 삭제하기
		public int deleteReview(Connection conn, int reviewNo) throws SQLException {
		
			int res = 0;
			Statement stmt = null;
			String sql = "DELETE FROM treview WHERE revid =" + reviewNo + ";";
			try {
				stmt= conn.createStatement();
				res=stmt.executeUpdate(sql);
			
			}finally {
				jdt.close(stmt);
		
			return res;
		}
		}
		
		// 이미 올린 리뷰 수정하기
		public int modifyReview(Connection conn, Review review) throws SQLException{
		
			
			int res = 0;
			
			ResultSet rs = null;
			PreparedStatement pstm = null;
			
			String sql = "update treview set revtitle = '?'"
					+ ", revContent = '?'"
					+ ", revStar = '?'"
					+ ", original_filepath = '?'"
					+ ", rename_filepath = '?' "
					+ "where revid = " + review.getReviewNo() ;
		
			try {
			pstm = conn.prepareStatement(sql);
			if(rs.next()) {
				Review selRevs=new Review();
				selRevs.setReviewTitle(rs.getString(2));
				selRevs.setReviewContent(rs.getString(5));
				selRevs.setReviewStar(rs.getInt(6));
				
				selRevs.setOriginal_filepath(rs.getString(8));
				selRevs.setRename_filepath(rs.getString(9));
			}
			res=pstm.executeUpdate();
			}finally {
				jdt.close(pstm);
			}
			return res;
			}
			
			
		public List<Review> selectNoticeList(Connection conn, Paging p, String orderby) throws SQLException{
		System.out.println(p.toString());
		List<Review> nlist = new ArrayList<Review>();
		String sql = "select * from (select rownum rnum, n1.* "
				+ "from ("
				+ "select * from tb_notice"
				+ " order by "+ orderby +" desc)n1)"
				+ "where rnum between ? and ?";
				
		PreparedStatement pstm=null;
		ResultSet rs = null;
		
		try {
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, p.getStart());
		pstm.setInt(2, p.getEnd());
				
		myRevs.setReviewTitle(rs.getString(2));
		myRevs.setReviewWriter(rs.getString(3));
		myRevs.setReviewContent(rs.getString(5));
		myRevs.setReviewStar(rs.getInt(6));
		myRevs.setMenuId(rs.getString(7));
		myRevs.setOriginal_filepath(rs.getString(8));
		myRevs.setRename_filepath(rs.getString(9));
		
		rs = pstm.executeQuery();
		while(rs.next()) {
			Review notice = new Review();
			notice.setReviewNo(rs.getInt(2));
			notice.setNoticeTitle(rs.getString(3));
			notice.setNoticeDate(rs.getDate(4));
			notice.setNoticeContent(rs.getString(5));
		
			nlist.add(notice);
		}
	}finally {
		jdt.close(pstm);
	}
	return nlist;
	}
		
	//각 메뉴 별점 : 선택메뉴의 전체 별점총점가져오기 나누기 카운트별점행수	
		
		public int getstarrate (Connection conn, Review review) throws SQLException{
			
			int res = 0;
			
			String sql = "select sum(revstar)/count(revstar) from treivew where menuid ="+review.getMenuId();
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt= conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next()) {
					res=rs.getInt(1);
			}
			}finally {
				jdt.close(rs,stmt);
		}
			return res;
	}
		
	
	//전체 리뷰게시물 갯수 가져오기
	public int contentCnt (Connection conn) throws SQLException {
			
			int res = 0;
			
			String sql = "select count(*) from treview";
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt= conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next()) {
					res=rs.getInt(1);
			}
			}finally {
				jdt.close(rs,stmt);
		}
			return res;
	}

	
	
}*/