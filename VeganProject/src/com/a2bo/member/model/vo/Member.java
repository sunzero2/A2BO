package com.a2bo.member.model.vo;

public class Member {
	private String userId;
	private String pw;
	private String cell;
	private String vLId;
	private String userEmail;
	private String nickname;

	public Member() {
		super();
	}

	public Member(String userId, String pw, String cell, String vLId, String userEmail, String nickname) {
		super();
		this.userId = userId;
		this.pw = pw;
		this.cell = cell;
		this.vLId = vLId;
		this.userEmail = userEmail;
		this.nickname = nickname;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", pw=" + pw + ", cell=" + cell + ", vLId=" + vLId + ", userEmail="
				+ userEmail + ", nickname=" + nickname + "]";
	}
}
