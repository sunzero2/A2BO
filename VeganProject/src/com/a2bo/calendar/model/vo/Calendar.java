package com.a2bo.calendar.model.vo;

public class Calendar {
	private String userId;
	private String cDate;
	private String icon;
	private String cMenu;
	private int cPrice;
	private String cCont;

	public Calendar() {
		super();
	}

	public Calendar(String userId, String cDate, String icon, String cMenu, int cPrice, String cCont) {
		super();
		this.userId = userId;
		this.cDate = cDate;
		this.icon = icon;
		this.cMenu = cMenu;
		this.cPrice = cPrice;
		this.cCont = cCont;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getcMenu() {
		return cMenu;
	}

	public void setcMenu(String cMenu) {
		this.cMenu = cMenu;
	}

	public int getcPrice() {
		return cPrice;
	}

	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}

	public String getcCont() {
		return cCont;
	}

	public void setcCont(String cCont) {
		this.cCont = cCont;
	}

	@Override
	public String toString() {
		return "Calendar [userId=" + userId + ", cDate=" + cDate + ", icon=" + icon + ", cMenu=" + cMenu + ", cPrice="
				+ cPrice + ", cCont=" + cCont + "]";
	}
}
