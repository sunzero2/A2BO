package com.a2bo.review.model.vo;

import java.sql.Date;

public class Review {
	private String reviewTitle;
	private String reviewContents;
	private int starRating;
	private int boardNum;
	private Date regDate;
	private String menuId;
	private String reviewWriter;

	public Review() {
		super();
	}

	public Review(String reviewTitle, String reviewContents, int starRating, int boardNum, Date regDate, String menuId,
			String reviewWriter) {
		super();
		this.reviewTitle = reviewTitle;
		this.reviewContents = reviewContents;
		this.starRating = starRating;
		this.boardNum = boardNum;
		this.regDate = regDate;
		this.menuId = menuId;
		this.reviewWriter = reviewWriter;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	@Override
	public String toString() {
		return "Review [reviewTitle=" + reviewTitle + ", reviewContents=" + reviewContents + ", starRating="
				+ starRating + ", boardNum=" + boardNum + ", regDate=" + regDate + ", menuId=" + menuId
				+ ", reviewWriter=" + reviewWriter + "]";
	}
}
