package com.a2bo.review.model.service;

import com.a2bo.review.model.dao.ReviewDao;

import common.JDBCTemplate;

public class ReviewService {
	private ReviewDao rDao = new ReviewDao();
	private JDBCTemplate jdbc = JDBCTemplate.getInstance();
	
	public ReviewService() {
		super();
	}
	
	public void uploadReview() {
		
	}
	
	public void modifyReview() {
		
	}
	
	public void deleteReview() {
		
	}
	
	public void starRating() {
		
	}
}
