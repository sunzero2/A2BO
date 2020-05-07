package com.a2bo.main.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.a2bo.main.model.dao.MainDao;
import com.a2bo.main.model.vo.MainVlv;

import common.JDBCTemplate;

public class MainService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	private MainDao mDao = new MainDao();

	public MainService() {
		super();
	}

	public List<MainVlv> searchingVg(List<Integer> list) {
		Connection conn = jdt.getConnection();
		List<MainVlv> vgList = new ArrayList<MainVlv>();
		try {
			vgList = mDao.searchingVg(conn, list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		return vgList;
	}

	public List<Map<String, Object>> searchingMenu(String myLevelId) {
		Connection conn = jdt.getConnection();
		List<Map<String, Object>> menu = null;
		try {
			menu = mDao.searchingMenu(conn, myLevelId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		return menu;
	}
}