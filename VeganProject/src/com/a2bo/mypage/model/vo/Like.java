package com.a2bo.mypage.model.vo;

public class Like {
	private String userId;
	private String menuId;
	private String likeYN;

	public Like() {
		super();
	}

	public Like(String userId, String menuId, String likeYN) {
		super();
		this.userId = userId;
		this.menuId = menuId;
		this.likeYN = likeYN;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getLikeYN() {
		return likeYN;
	}

	public void setLikeYN(String likeYN) {
		this.likeYN = likeYN;
	}

	@Override
	public String toString() {
		return "Like [userId=" + userId + ", menuId=" + menuId + ", likeYN=" + likeYN + "]";
	}
}
