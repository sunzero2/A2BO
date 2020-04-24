package com.a2bo.member.model.vo;

public class Member {
	private String userId;
	private String pw;
	private String cell;
	private String vLId;
	private String nickname;
	private String menuId;
	private String likeYN;

	public Member() {
		super();
	}

	public Member(String userId, String pw, String cell, String vLId, String nickname, String menuId, String likeYN) {
		super();
		this.userId = userId;
		this.pw = pw;
		this.cell = cell;
		this.vLId = vLId;
		this.nickname = nickname;
		this.menuId = menuId;
		this.likeYN = likeYN;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getvLId() {
		return vLId;
	}

	public void setvLId(String vLId) {
		this.vLId = vLId;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return "Member [userId=" + userId + ", pw=" + pw + ", cell=" + cell + ", vLId=" + vLId + ", nickname="
				+ nickname + ", menuId=" + menuId + ", likeYN=" + likeYN + "]";
	}
}
