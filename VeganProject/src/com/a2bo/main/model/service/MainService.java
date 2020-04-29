package com.a2bo.main.model.service;

import java.sql.Connection;
import java.sql.SQLException;
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
	
	public MainVlv searchingVg(List<Integer> vg) {
		
		Connection conn = jdt.getConnection();
		Map<Integer, Object> vgMap = new HashMap<>();
		
		try {
			MainVlv mvl = mDao.searchingVg(conn, vg);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdt.close(conn);
		}
		
		
		return mvl;
	}


	
}
