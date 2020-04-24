package com.a2bo.main.model.vo;

import java.io.Serializable;

public class MainMenu implements Serializable {

	private static final long serialVersionUID = 5596571680892745243L;
	private String menuId;
	private String restId;
	private String vLId;
	private String menuName;
	private int menuPrice;

	public MainMenu() {
		super();
	}

	public MainMenu(String menuId, String restId, String vLId, String menuName, int menuPrice) {
		super();
		this.menuId = menuId;
		this.restId = restId;
		this.vLId = vLId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public String getvLId() {
		return vLId;
	}

	public void setvLId(String vLId) {
		this.vLId = vLId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	@Override
	public String toString() {
		return "MainMenu [menuId=" + menuId + ", restId=" + restId + ", vLId=" + vLId + ", menuName=" + menuName
				+ ", menuPrice=" + menuPrice + "]";
	}
}
