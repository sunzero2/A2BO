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

import com.a2bo.main.model.vo.MainMenu;
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
			

			while(rs.next()){
				MainVlv mainvlv = new MainVlv();
				mainvlv.setvLid(rs.getString(1));
	
				
				mvl.add(mainvlv);
				
			}
			
		}finally {
			jdt.close(rs, stmt);
		}
		

		//System.out.println("다오에서 리스트 :" + list);
		//System.out.println("다오에서 sql : " + sql);
		//System.out.println("다오에서 pstm : " + stmt);
		//System.out.println("다오에서 rs : " + rs);
		//System.out.println("다오에서 mvl : " + mvl);
	
		return mvl;
		
	}
	
	
	
	
	public Map<String, Object> searchingMenu(Connection conn,String myLevelId) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> menu = null;
		
		String sql = "select * from tmenu  inner join trest using (restid) where vlid like '" + myLevelId + "'";
		List<Map<String, Object>> result  = null;
		sql += " and Rownum <5";
		try {
			result = new ArrayList<Map<String,Object>>();
			menu = new HashMap<String, Object>();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			
			while(rs.next()) {
					//디비에서 출력되는 순서
					//레스트 아이디,메뉴 아이디, 비건 아이디, 메뉴이름, 가격, 레스트 이름, 주소, 전화번호, 매장영업시간, 레스트체인점
					menu.put("메뉴이름", rs.getString(4));
					menu.put("가격", rs.getInt(5));
					menu.put("레스트 이름", rs.getString(6));
					menu.put("주소", rs.getString(7));
					menu.put("전화번호", rs.getString(8));
					menu.put("영업시간", rs.getString(9));
					result.add(menu);		
					
							
					System.out.println(menu);

					
//					for(int i=0; i < 5; i++) {
//						System.out.println(menu.get(i));
//					}
					
					
		    }
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdt.close(rs, pstm);
		}
		
		System.out.println("서칭 메뉴 다오단에서 " + menu);
		
		System.out.println(sql);
		
		return menu;
		
	
	}
}
