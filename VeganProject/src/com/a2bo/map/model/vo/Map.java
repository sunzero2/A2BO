package com.a2bo.map.model.vo;

public class Map {
	private int xlatitude;
	private int ylongitude;
	private String menuLocation;
	private String menuId;
	private String restId;

	public Map() {
		super();
	}

	public int getXlatitude() {
		return xlatitude;
	}

	public void setXlatitude(int xlatitude) {
		this.xlatitude = xlatitude;
	}

	public int getYlongitude() {
		return ylongitude;
	}

	public void setYlongitude(int ylongitude) {
		this.ylongitude = ylongitude;
	}

	public String getMenuLocation() {
		return menuLocation;
	}

	public void setMenuLocation(String menuLocation) {
		this.menuLocation = menuLocation;
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

	@Override
	public String toString() {
		return "Map [xlatitude=" + xlatitude + ", ylongitude=" + ylongitude + ", menuLocation=" + menuLocation
				+ ", menuId=" + menuId + ", restId=" + restId + "]";
	}
	
	

}
