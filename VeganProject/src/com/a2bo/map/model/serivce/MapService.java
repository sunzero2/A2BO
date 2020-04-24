package com.a2bo.map.model.serivce;

import com.a2bo.map.model.dao.MapDao;

import common.JDBCTemplate;

public class MapService {
	private MapDao mDao = new MapDao();
	private JDBCTemplate jdbc = JDBCTemplate.getInstance();

	public MapService() {
		super();
	}

	public void myLoc() {

	}

	public void showAllLoc() {

	}

	public void showSelectedLoc() {

	}
}
