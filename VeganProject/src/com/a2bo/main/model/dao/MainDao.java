package com.a2bo.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.a2bo.main.model.vo.MainVlv;

import common.JDBCTemplate;

public class MainDao {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public MainDao() {
		super();
	}
	
	public List<MainVlv> searchingVg(Connection conn, List<Integer> list) throws SQLException {
		
		//PreparedStatement pstm = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MainVlv> mvl = new ArrayList<MainVlv>();
		//MainVlv mvl = null;
		String sql = "select vlid from tvl where ";
		
		for(int i = 0; i < list.size(); i++) {
			
			switch(list.get(i)) {
				case 1 : sql += "meat= 'Y' and ";
					break;
				case 2 : sql += "bird= 'Y' and ";	
					break;
				case 3 : sql += "fish= 'Y' and ";	
					break;
				case 4 : sql += "eggs= 'Y' and ";	
					break;
				case 5 : sql += "milk= 'Y' and ";	
					break;
				case 6 : sql += "mushroom= 'Y' and ";	
					break;
				case 7 : sql += "seeweed= 'Y' and ";	
					break;
				case 8 : sql += "veg= 'Y' and ";	
					break;
				case 9 : sql += "fruit= 'Y' and";	
					break;
			}
		}
		
		sql = sql.substring(0, sql.length()-4);
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
//			if(rs.next()) {
				
//				mvl = new MainVlv(rs.getString(1), sql, sql, sql, sql, sql, sql, sql, sql, sql);
//				level = rs.getString(1);
				//mvl.setvLid(rs.getString(1));
				
				/*mlv.setMeat(rs.getString(1));
				mlv.setBird(rs.getString(1));
				mlv.setFish(rs.getString(1));
				mlv.setEggs(rs.getString(1));
				mlv.setMilk(rs.getString(1));
				mlv.setMushroom(rs.getString(1));
				mlv.setSeeweed(rs.getString(1));
				mlv.setVeg(rs.getString(1));
				mlv.setFruit(rs.getString(1));*/
			while(rs.next()){
				MainVlv mainvlv = new MainVlv();
				mainvlv.setvLid(rs.getString(1));
	
				
				mvl.add(mainvlv);
				
			}
			
		}finally {
			jdt.close(rs, stmt);
		}
		

		System.out.println("다오에서 리스트 :" + list);
		System.out.println("다오에서 sql : " + sql);
		System.out.println("다오에서 pstm : " + stmt);
		System.out.println("다오에서 rs : " + rs);
		System.out.println("다오에서 mvl : " + mvl);
	
	return mvl;
		
	}
	
	public Map<Integer, Object> searchingMenu(String myLevel) {
		
		
		
		
		return null;
	}
}
