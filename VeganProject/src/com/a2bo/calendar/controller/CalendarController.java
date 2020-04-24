package com.a2bo.calendar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalendarController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI().substring(request.getContextPath().length());
		RequestDispatcher rd = null;
		
		if(command.contains("main")) {
			rd = request.getRequestDispatcher("/WEB-INF/views/calendar/calendar.jsp");
		} else if(command.contains("calSub")) {
			rd = request.getRequestDispatcher("/WEB-INF/views/calendar/calendarSub.jsp");
		}

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	// 일정 추가 메서드
	private void addEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 일정 변경 메서드
	private void changeEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 일정 삭제 메서드
	private void removeEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 일정 리스트 가져오는 메서드
	private void eventList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 메모 변경 메서드
	private void changeMemo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
