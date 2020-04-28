package com.a2bo.calendar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public void eventList() {
		
	}
	
	public void changeMemo() {
		
	}
	
}
