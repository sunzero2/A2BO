package com.a2bo.calendar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.session.PersistentManager;

import com.a2bo.calendar.model.vo.Calendar;

import common.JDBCTemplate;

public class CalendarDao {
	JDBCTemplate jdbc = JDBCTemplate.getInstance();
	
	public CalendarDao() {
		super();
	}
	
	public int addEvent(Connection conn, Calendar cal) throws SQLException {
		String sql = "insert into tcalendar values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cal.getUserId());
			pstm.setString(2, cal.getcDate());
			pstm.setString(3, cal.getIcon());
			pstm.setString(4, cal.getcMenu());
			pstm.setInt(5, cal.getcPrice());
			pstm.setString(6, cal.getcCont());
			
			res = pstm.executeUpdate();
		} finally {
			jdbc.close(pstm);
		}
		return res;
	}
	
	public void changeEvent() {
		
	}
	
	public void removeEvent() {
		
	}
	
	public List<Calendar> eventList(Connection conn, int userid, int month) throws SQLException {
		String sql = "select * from tcalendar where userid = ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Calendar calendar = null;
		List<Calendar> calList = new ArrayList<>();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userid);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				calendar = new Calendar();
				calendar.setUserId(rs.getInt(1));
				calendar.setcDate(rs.getString(2));
				calendar.setIcon(rs.getString(3));
				calendar.setcMenu(rs.getString(4));
				calendar.setcPrice(rs.getInt(5));
				calendar.setcCont(rs.getString(6));
				
				calList.add(calendar);
			}
		} finally {
			jdbc.close(rs, pstm);
		}
		
		return calList;
	}
	
	public void changeMemo() {
		
	}
	
}
