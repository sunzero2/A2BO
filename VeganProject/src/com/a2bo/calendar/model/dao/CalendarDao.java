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
	
	public void changeEvent() {
		
	}
	
	public void removeEvent() {
		
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
	
	public void changeMemo() {
		
	}
	
	
	public Calendar getEvent(Connection conn, int userid, String day) throws SQLException {
		String sql = "select * from tcalendar where userid = '" + userid + "' and cdate = '" + day + "'";
		Statement stmt = null;
		ResultSet rs = null;
		Calendar calendar = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				calendar = new Calendar();
				calendar.setIcon(rs.getString(3));
				calendar.setcMenu(rs.getString(4));
				calendar.setcPrice(rs.getInt(5));
				calendar.setcCont(rs.getString(6));
			}
		} finally {
			jdbc.close(rs, stmt);
		}
		
		return calendar;
	}
}
