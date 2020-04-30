package com.a2bo.calendar.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
	
	public List<Calendar> eventList(int userid, String month) {
		Connection conn = jdbc.getConnection();
		List<Calendar> calList = null;
		
		try {
			calList = cDao.eventList(conn, userid, month);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return calList;
	}
	
	public void changeMemo() {
		
	}
	
	public Calendar getEvent(int userid, String day) {
		Calendar calendar = null;
		Connection conn = jdbc.getConnection();
		try {
			calendar = cDao.getEvent(conn, userid, day);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return calendar;
	}
}
