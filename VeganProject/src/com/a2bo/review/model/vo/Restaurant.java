package com.a2bo.review.model.vo;

public class Restaurant {

	private String restId;
	private String restName;
	private String restLoc;
	private String restPhone;
	private String restHour;
	private String restBranch;
	//DB TREST restBranch Typo
	
	public Restaurant() {
		super();
	}

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getRestLoc() {
		return restLoc;
	}

	public void setRestLoc(String restLoc) {
		this.restLoc = restLoc;
	}

	public String getRestPhone() {
		return restPhone;
	}

	public void setRestPhone(String restPhone) {
		this.restPhone = restPhone;
	}

	public String getRestHour() {
		return restHour;
	}

	public void setRestHour(String restHour) {
		this.restHour = restHour;
	}

	public String getRestBranch() {
		return restBranch;
	}

	public void setRestBranch(String restBranch) {
		this.restBranch = restBranch;
	}

	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", restName=" + restName + ", restLoc=" + restLoc + ", restPhone="
				+ restPhone + ", restHour=" + restHour + ", restBranch=" + restBranch + "]";
	}

	
	
	
}
