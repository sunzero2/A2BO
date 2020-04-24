package com.a2bo.main.model.vo;

import java.io.Serializable;

public class MainVlv implements Serializable {

	private static final long serialVersionUID = -5914828431285476556L;
	private String vLId;
	private String meat;
	private String bird;
	private String fish;
	private String eggs;
	private String milk;
	private String mushroom;
	private String seeweed;
	private String veg;
	private String fruit;

	public MainVlv() {
		super();
	}

	public MainVlv(String vLId, String meat, String bird, String fish, String eggs, String milk, String mushroom,
			String seeweed, String veg, String fruit) {
		super();
		this.vLId = vLId;
		this.meat = meat;
		this.bird = bird;
		this.fish = fish;
		this.eggs = eggs;
		this.milk = milk;
		this.mushroom = mushroom;
		this.seeweed = seeweed;
		this.veg = veg;
		this.fruit = fruit;
	}

	public String getvLid() {
		return vLId;
	}

	public void setvLid(String vLId) {
		this.vLId = vLId;
	}

	public String getMeat() {
		return meat;
	}

	public void setMeat(String meat) {
		this.meat = meat;
	}

	public String getBird() {
		return bird;
	}

	public void setBird(String bird) {
		this.bird = bird;
	}

	public String getFish() {
		return fish;
	}

	public void setFish(String fish) {
		this.fish = fish;
	}

	public String getEggs() {
		return eggs;
	}

	public void setEggs(String eggs) {
		this.eggs = eggs;
	}

	public String getMilk() {
		return milk;
	}

	public void setMilk(String milk) {
		this.milk = milk;
	}

	public String getMushroom() {
		return mushroom;
	}

	public void setMushroom(String mushroom) {
		this.mushroom = mushroom;
	}

	public String getSeeweed() {
		return seeweed;
	}

	public void setSeeweed(String seeweed) {
		this.seeweed = seeweed;
	}

	public String getVeg() {
		return veg;
	}

	public void setVeg(String veg) {
		this.veg = veg;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	@Override
	public String toString() {
		return "MainVlv [vLId=" + vLId + ", meat=" + meat + ", bird=" + bird + ", fish=" + fish + ", eggs=" + eggs
				+ ", milk=" + milk + ", mushroom=" + mushroom + ", seeweed=" + seeweed + ", veg=" + veg + ", fruit="
				+ fruit + "]";
	}
}
