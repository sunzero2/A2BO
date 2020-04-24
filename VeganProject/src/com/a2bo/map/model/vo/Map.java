package com.a2bo.map.model.vo;

public class Map {
	private int myLocation;
	private int menuLocation;
	private String menuId;

	public Map() {
		super();
	}

	public Map(int myLocation, int menuLocation, String menuId) {
		super();
		this.myLocation = myLocation;
		this.menuLocation = menuLocation;
		this.menuId = menuId;
	}

	public int getMyLocation() {
		return myLocation;
	}

	public void setMyLocation(int myLocation) {
		this.myLocation = myLocation;
	}

	public int getMenuLocation() {
		return menuLocation;
	}

	public void setMenuLocation(int menuLocation) {
		this.menuLocation = menuLocation;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "Map [myLocation=" + myLocation + ", menuLocation=" + menuLocation + ", menuId=" + menuId + "]";
	}
}
