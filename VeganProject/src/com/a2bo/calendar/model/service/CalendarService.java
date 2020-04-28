package com.a2bo.calendar.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.a2bo.calendar.model.dao.CalendarDao;
import com.a2bo.calendar.model.vo.Calendar;

import common.JDBCTemplate;

public class CalendarService {
	JDBCTemplate jdbc = JDBCTemplate.getInstance();
	CalendarDao cDao = new CalendarDao();
	
	public CalendarService() {
		super();
	}
	
	public int addEvent(Calendar cal) {
		int res = 0;
		Connection conn = jdbc.getConnection();
		try {
			res = cDao.addEvent(conn, cal);
			jdbc.commit(conn);
		} catch (SQLException e) {
			jdbc.rollback(conn);
			e.printStackTrace();
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
