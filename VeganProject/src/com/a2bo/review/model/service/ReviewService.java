package com.a2bo.review.model.service;

import com.a2bo.review.model.dao.ReviewDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.a2bo.review.model.dao.ReviewDao;
import com.a2bo.review.model.vo.Review;
import common.JDBCTemplate;
import common.util.Paging;

import common.JDBCTemplate;

public class ReviewService {
	private ReviewDao rDao = new ReviewDao();
	private JDBCTemplate jdbc = JDBCTemplate.getInstance();
	
	public ReviewService() {
		super();
	}
	
	public List<Review> myReviews(String id) {

		Connection con = jdbc.getConnection();
		List<Review> myRlist = new ArrayList<>();

		try {
			myRlist = rDao.myReviews(con, id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(con);
		}

		return myRlist;
	}

	public int reviewUpload(Review review) {

		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res = rDao.reviewUpload(conn, review);
			jdbc.commit(conn);
		} catch (SQLException e) {
			jdbc.rollback(conn);
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}

	public int deleteReview(int reviewNo) {

		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res = rDao.deleteReview(conn, reviewNo);
			jdbc.commit(conn);
		} catch (SQLException e) {
			jdbc.rollback(conn);
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}
	
	public int modifyReview(Review review) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res = rDao.modifyReview(conn, review);
			jdbc.commit(conn);
		} catch (SQLException e) {
			jdbc.rollback(conn);
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}
	
	public int getStarrate(String menuid) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res = rDao.getStarrate(conn, menuid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}
   
	public int contentCnt (String menuid) {
		
		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res=rDao.contentCnt(conn, menuid);
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}
		
	//선택한 메뉴의 리뷰리스트를 nlist키값에 담아 페이지 수와 갯수에맞게 뿌려줌
	   public Map<String, Object> selectedRevList(String menuid, int currentPage, int cntPerPage){
	       Map<String, Object> res = new HashMap<>();
	       Connection con = jdbc.getConnection();
	       Paging p = null;
	       List<Review> rlist = null;
	       
	       try {
	         p = new Paging(rDao.contentCnt(con, menuid),currentPage, cntPerPage);
	         rlist = rDao.selectedRevList(con, p);
	         res.put("paging", p);
	         res.put("nlist", rlist);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	    	  jdbc.close(con);
	      }
	       
	       
	       return res;
	   }
   
   }