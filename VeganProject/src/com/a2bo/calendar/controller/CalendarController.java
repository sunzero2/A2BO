package com.a2bo.calendar.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.tribes.util.Arrays;
import org.eclipse.jdt.internal.compiler.lookup.MemberTypeBinding;
import com.a2bo.calendar.model.service.CalendarService;
import com.a2bo.calendar.model.vo.Calendar;
import com.a2bo.member.model.vo.Member;
import com.sun.xml.internal.txw2.Document;

import sun.management.counter.Variability;

public class CalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CalendarService cService = new CalendarService();   
	
    public CalendarController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI().substring(request.getContextPath().length());
		RequestDispatcher rd = null;
		
		if(command.contains("main")) {
			List<Calendar> calList = eventList(request, response);
			request.setAttribute("calList", calList);
			rd = request.getRequestDispatcher("/WEB-INF/views/calendar/calendar.jsp");
			rd.forward(request, response);
		} else if(command.contains("calSub")) {
			rd = request.getRequestDispatcher("/WEB-INF/views/calendar/calendarSub.jsp");
			rd.forward(request, response);
		} else if(command.contains("addEvent")) {
			addEvent(request, response);
		} else if(command.contains("calList")) {
			List<Calendar> calList = eventList(request, response);
			request.setAttribute("calList", calList);
		} else if(command.contains("memoList")) {
			
		} else if(command.contains("getEvent")) {
			getEvent(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	// 일정 추가 메서드
	private void addEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginInfo");
		String cCont = request.getParameter("content");
		String icon = request.getParameter("icon");
		int cPrice = Integer.parseInt(request.getParameter("price"));
		String cMenu = request.getParameter("menu");
		String date = request.getParameter("date");
		int userId = member.getUserId();
		
		String year = date.substring(0, 4);
		String month = "";
		if(date.substring(7, 8).equals("월")) {
			month = "0" + date.substring(6, 7);
		} else {
			month = date.substring(6, 8);
		}
		String day = date.substring(date.length()-2, date.length());
		
		String cDate = year + "/" + month + "/" + day;
		Calendar calendar = new Calendar();
		calendar.setcCont(cCont);
		calendar.setcDate(cDate);
		calendar.setcMenu(cMenu);
		calendar.setcPrice(cPrice);
		calendar.setIcon(icon);
		calendar.setUserId(userId);
		
		System.out.println(icon);
		
		int res = cService.addEvent(calendar);
		
		if(res > 0) {
			request.setAttribute("success", calendar);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/calendar/calendarSub.jsp");
		rd.forward(request, response);
	}
	
	// 일정 변경 메서드
	private void changeEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 일정 삭제 메서드
	private void removeEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 일정 리스트 가져오는 메서드
	private List<Calendar> eventList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userid = ((Member)session.getAttribute("loginInfo")).getUserId();
		String month = "";
		
		if(request.getParameter("month") == null) {
			GregorianCalendar calendar = new GregorianCalendar();
			month = String.valueOf(calendar.get(calendar.MONTH) + 1);
		} else {
			month = request.getParameter("month");
		}
		
		List<Calendar> calList = cService.eventList(userid, month);
		return calList;
	}
	
	// 메모 변경 메서드
	private void changeMemo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	/**
	 1. MethodName : getEvent
	 2. ClassName : CalendarController.java
	 3. Comment : 단일 일정 가져오는 메소드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 5. 1.
	 */
	private void getEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = ((Member)request.getSession().getAttribute("loginInfo")).getUserId();
		String day = request.getParameter("day");
		
		Calendar calendar = cService.getEvent(userid, day);
		
		PrintWriter pw = response.getWriter();
		pw.print(calendar);
	}
}
