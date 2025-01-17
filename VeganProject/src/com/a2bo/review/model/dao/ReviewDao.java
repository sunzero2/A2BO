package com.a2bo.review.model.dao;

import java.awt.Window;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.a2bo.member.model.vo.Member;
import com.a2bo.review.model.vo.Review;
import common.JDBCTemplate;
import common.util.Paging;


public class ReviewDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public ReviewDao() {

	}
	// 내리뷰가져오기 아이디로 불러와서 리스트에 담아 반환
	// 작성자 Kate
	// Mypage랑 연동되어 관리가능
	public List<Review> myReviews(Connection conn, String id) throws SQLException {

		List<Review> rlist = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		String sql = "select * from treview where userid = ?";
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Review myRevs = new Review();
				myRevs.setReviewNo(rs.getInt(1));
				myRevs.setReviewTitle(rs.getString(2));
				myRevs.setReviewWriter(rs.getInt(3));
				myRevs.setReviewDate(rs.getDate(4));
				myRevs.setReviewContent(rs.getString(5));
				myRevs.setReviewStar(rs.getInt(6));
				myRevs.setMenuId(rs.getString(7));
				myRevs.setOriginal_filepath(rs.getString(8));
				myRevs.setRename_filepath(rs.getString(9));

				rlist.add(myRevs);
			}

		} finally {
			jdt.close(rs, pstmt);
		}
		return rlist;
	}

	// review upload method service에서 커밋해줄것.

	public int reviewUpload(Connection conn, Review review) throws SQLException {

		int res = 0;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		String sql = "insert into treview values(s_notice.nextval,?,?,sysdate,?,?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			if (rs.next()) {
				Review myRevs = new Review();

				myRevs.setReviewTitle(rs.getString(2));
				myRevs.setReviewWriter(rs.getInt(3));
				myRevs.setReviewContent(rs.getString(5));
				myRevs.setReviewStar(rs.getInt(6));
				myRevs.setMenuId(rs.getString(7));
				myRevs.setOriginal_filepath(rs.getString(8));
				myRevs.setRename_filepath(rs.getString(9));

			}
			res = pstm.executeUpdate();
		} finally {
			jdt.close(pstm);
		}
		return res;
	}

	// 리뷰 삭제하기
	public int deleteReview(Connection conn, int reviewNo) throws SQLException {

		int res = 0;
		Statement stmt = null;
		String sql = "DELETE FROM treview WHERE revid =" + reviewNo + ";";
		try {
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);

		} finally {
			jdt.close(stmt);
		}
		return res;
	}

	// 이미 올린 리뷰 수정하기
	public int modifyReview(Connection conn, Review review) throws SQLException {

		int res = 0;

		ResultSet rs = null;
		PreparedStatement pstm = null;

		String sql = "update treview set revtitle = '?'" + ", revContent = '?'" + ", revStar = '?'"
				+ ", original_filepath = '?'" + ", rename_filepath = '?' " + "where revid = " + review.getReviewNo();

		try {
			pstm = conn.prepareStatement(sql);
			if (rs.next()) {
				Review selRevs = new Review();
				selRevs.setReviewTitle(rs.getString(2));
				selRevs.setReviewContent(rs.getString(5));
				selRevs.setReviewStar(rs.getInt(6));

				selRevs.setOriginal_filepath(rs.getString(8));
				selRevs.setRename_filepath(rs.getString(9));
			}
			res = pstm.executeUpdate();
		} finally {
			jdt.close(pstm);
		}
		return res;
	}

	// 각 메뉴 별점 : 선택메뉴의 전체 별점총점가져오기 나누기 카운트별점행수

	public int getStarrate(Connection conn, String menuid) throws SQLException {

		int res = 0;

		String sql = "select sum(revstar)/count(revstar) from treivew where menuid =" + menuid;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				res = rs.getInt(1);
			}
		} finally {
			jdt.close(rs, stmt);
		}
		return res;
	}

	// 선택된 메뉴  리뷰게시물 갯수 가져오기
	public int contentCnt(Connection conn, String menuid) throws SQLException {

		int res = 0;

		String sql = "select count(revMenu) from treview where meuid = "+ menuid;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				res = rs.getInt(1);
			}
		} finally {
			jdt.close(rs, stmt);
		}
		return res;
	}
	
	//선택한 메뉴의 리뷰리스트를 nlist키값에 담아 페이지 수와 갯수에맞게 뿌려줌
	public List<Review> selectedRevList(Connection conn, Paging p) throws SQLException {

		List<Review> rlist = new ArrayList<Review>();

		String sql = "select * from (select rownum rnum, n1.* from ("
				+ "select * from treview order by revDate desc)n1)" + "where rnum between ? and ?";

		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, p.getStart());
			pstm.setInt(2, p.getEnd());

			rs = pstm.executeQuery();

			while (rs.next()) {
				Review review = new Review();			
				review.setReviewTitle(rs.getString(2));
				review.setReviewWriter(rs.getInt(3));
				review.setReviewDate(rs.getDate(4));
				review.setReviewContent(rs.getString(5));
				review.setReviewStar(rs.getInt(6));
				review.setMenuId(rs.getString(7));
				review.setOriginal_filepath(rs.getString(8));
				review.setRename_filepath(rs.getString(9));

				rlist.add(review);
			}
		} finally {
			jdt.close(pstm);
		}
		return rlist;

	}

}