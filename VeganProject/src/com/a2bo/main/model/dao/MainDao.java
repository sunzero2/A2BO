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
		Statement stmt = null;
		ResultSet rs = null;
		List<MainVlv> mvl = new ArrayList<MainVlv>();
		String sql = "select vlid from tvl where ";

		for (int i = 0; i < list.size(); i++) {

			switch (list.get(i)) {
			case 1:
				sql += "meat= 'Y' and ";
				break;
			case 2:
				sql += "bird= 'Y' and ";
				break;
			case 3:
				sql += "fish= 'Y' and ";
				break;
			case 4:
				sql += "eggs= 'Y' and ";
				break;
			case 5:
				sql += "milk= 'Y' and ";
				break;
			case 6:
				sql += "mushroom= 'Y' and ";
				break;
			case 7:
				sql += "seeweed= 'Y' and ";
				break;
			case 8:
				sql += "veg= 'Y' and ";
				break;
			case 9:
				sql += "fruit= 'Y' and ";
				break;
			}
		}
		sql = sql.substring(0, sql.length() - 4);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MainVlv mainvlv = new MainVlv();
				mainvlv.setvLid(rs.getString(1));
				mvl.add(mainvlv);
			}
		} finally {
			jdt.close(rs, stmt);
		}
		
		return mvl;
	}

	public List<Map<String, Object>> searchingMenu(Connection conn, String myLevelId) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> menu = null;

		String sql = "select * from tmenu  inner join trest using (restid) where vlid like '" + myLevelId + "'";
		List<Map<String, Object>> result = null;
		sql += " and Rownum < 7";
		try {
			result = new ArrayList<Map<String, Object>>();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				menu = new HashMap<>();
				menu.put("메뉴아이디", rs.getString(2));
				menu.put("메뉴이름", rs.getString(4));
				menu.put("가격", rs.getInt(5));
				menu.put("식당명", rs.getString(6));
				menu.put("주소", rs.getString(7));
				menu.put("전화번호", rs.getString(8));
				menu.put("영업시간", rs.getString(9));
				result.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(rs, pstm);
		}
		return result;
	}
}