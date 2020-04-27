package com.a2bo.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import common.JDBCTemplate;

public class MainDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public MainDao() {
		super();
	}
	
	public Map<Integer, Object> searchingVg(Connection conn, String vg) {
		
		Map<Integer,Object> result = null;
		PreparedStatement pstm = null;
		Statement stmt = null;
		ResultSet rs = null;
		
	
		
		
		
		return null;
	}
	
	public Map<Integer, Object> searchingMenu() {
		
		
		
		
		return null;
	}
}
