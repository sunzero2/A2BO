package com.a2bo.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public MainVlv searchingVg(Connection conn, List<Integer> vg) throws SQLException {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MainVlv mvl = null;
		String sql = "select vlid from tvl where ";
		
		for(int i = 0; i < vg.size(); i++) {
			
			switch(vg.get(i)) {
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
		
		sql.substring(0, sql.length()-4);
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				
				mvl = new MainVlv();
				
				mvl.setvLid(rs.getString(1));
				
				/*mlv.setMeat(rs.getString(1));
				mlv.setBird(rs.getString(1));
				mlv.setFish(rs.getString(1));
				mlv.setEggs(rs.getString(1));
				mlv.setMilk(rs.getString(1));
				mlv.setMushroom(rs.getString(1));
				mlv.setSeeweed(rs.getString(1));
				mlv.setVeg(rs.getString(1));
				mlv.setFruit(rs.getString(1));*/
			}
			
		}finally {
			jdt.close(rs, pstm);
		}
			
	
		return mvl;
	}
	
	public Map<Integer, Object> searchingMenu() {
		
		
		
		
		return null;
	}
}
