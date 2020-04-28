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
	
	public int getStarrate(Review review) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res = rDao.getstarrate(conn, review);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close(conn);
		}
		return res;
	}
	
	public void contentCnt() {
		
	}
   
   public Review selectNotice(int reviewNo) {
	   Review review = null;
	   Connection conn = jdbc.getConnection();
	   
	   try {
		review=rDao.selectNotice(conn,reviewNo);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		jdbc.close(conn);
	}
	return review;
   }
  
	   
	   public Map<String, Object> selectNoticeList(String orderby, int currentPage, int cntPerPage){
	       Map<String, Object> res = new HashMap<>();
	       Connection con = jdbc.getConnection();
	       Paging p = null;
	       List<Notice> nlist = null;
	       
	       try {
	         p = new Paging(nDao.contentCnt(con),currentPage, cntPerPage);
	         nlist = nDao.selectNoticeList(con, p, orderby);
	         res.put("paging", p);
	         res.put("nlist", nlist);
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	    	  jdbc.close(con);
	      }
	       
	       
	       return res;
	   }
   
   }
   
   
   
