package com.a2bo.calendar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.session.PersistentManager;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.a2bo.calendar.model.vo.Calendar;
import com.google.common.util.concurrent.Service.State;

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
	
	public int changeEvent(Connection conn, Calendar calendar) throws SQLException {
		String sql = "update tcalendar set icon=?, cmenu=?, cprice=?, ccont=? where userid=? and cdate=?";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, calendar.getIcon());
			pstm.setString(2, calendar.getcMenu());
			pstm.setInt(3, calendar.getcPrice());
			pstm.setString(4, calendar.getcCont());
			pstm.setInt(5, calendar.getUserId());
			pstm.setString(6, calendar.getcDate());
			
			res = pstm.executeUpdate();
			
		} finally {
			jdbc.close(pstm);
		}
		
		return res;
	}
	
	public int removeEvent(Connection conn, int userid, String cdate) throws SQLException {
		String sql = "delete from tcalendar where userid=? and cdate=?";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userid);
			pstm.setString(2, cdate);
			
			res = pstm.executeUpdate();
			
		} finally {
			jdbc.close(pstm);
		}
		return res;
	}
	
	public List<Calendar> eventList(Connection conn, int userid, String month) throws SQLException {
		String sql = "select * from (select substr(cdate, 6, 2) month, tcalendar.* from tcalendar where userid = " + userid + ") v where v.month like '%"+ month + "%'";
		Statement pstm = null;
		ResultSet rs = null;
		Calendar calendar = null;
		List<Calendar> calList = new ArrayList<>();
		
		try {
			pstm = conn.createStatement();
			rs = pstm.executeQuery(sql);
			
			while(rs.next()) {
				calendar = new Calendar();
				calendar.setUserId(rs.getInt(2));
				calendar.setcDate(rs.getString(3));
				calendar.setIcon(rs.getString(4));
				calendar.setcMenu(rs.getString(5));
				calendar.setcPrice(rs.getInt(6));
				calendar.setcCont(rs.getString(7));
				
				calList.add(calendar);
			}
		} finally {
			jdbc.close(rs, pstm);
		}
		
		return calList;
	}
	
	public Calendar getEvent(Connection conn, String userid, String date) throws SQLException {
		String sql = "select * from tcalendar where userid = ? and cdate like ?";
		

		PreparedStatement pstm = null;
		ResultSet rs = null;
		Calendar calendar = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userid);
			pstm.setString(2, date);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				calendar = new Calendar();
				calendar.setIcon(rs.getString(3));
				calendar.setcMenu(rs.getString(4));
				calendar.setcPrice(rs.getInt(5));
				calendar.setcCont(rs.getString(6));
			}
		} finally {
			jdbc.close(rs, pstm);
		}
		
		return calendar;
	}
}
