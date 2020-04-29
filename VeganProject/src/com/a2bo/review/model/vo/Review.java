package com.a2bo.review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3179650745480378326L;

	private int reviewNo;
	private String reviewTitle;
	private String reviewWriter;
	private Date reviewDate;
	private String reviewContent;
	private int reviewStar;
	private String menuId;
	private String original_filepath;
	private String rename_filepath;
	
	public Review(){
		
	}

	public Review(int reviewNo, String reviewTitle, String reviewWriter, Date reviewDate, String reviewContent,
			int reviewStar, String menuId, String original_filepath, String rename_filepath) {
		super();
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewWriter = reviewWriter;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.reviewStar = reviewStar;
		this.menuId = menuId;
		this.original_filepath = original_filepath;
		this.rename_filepath = rename_filepath;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getOriginal_filepath() {
		return original_filepath;
	}

	public void setOriginal_filepath(String original_filepath) {
		this.original_filepath = original_filepath;
	}

	public String getRename_filepath() {
		return rename_filepath;
	}

	public void setRename_filepath(String rename_filepath) {
		this.rename_filepath = rename_filepath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewTitle=" + reviewTitle + ", reviewWriter=" + reviewWriter
				+ ", reviewDate=" + reviewDate + ", reviewContent=" + reviewContent + ", reviewStar=" + reviewStar
				+ ", menuId=" + menuId + ", original_filepath=" + original_filepath + ", rename_filepath="
				+ rename_filepath + "]";
	}

	
	
	
	
}