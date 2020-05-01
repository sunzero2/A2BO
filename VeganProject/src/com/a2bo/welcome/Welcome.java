package com.a2bo.welcome;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8787/vgan/welcome 으로 들어오면
//Welcome 클래스를 통해서 main.jsp로 이동.
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Welcome() {
     super();
 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/main/main.jsp");
		// 새로고침할때마다 쿠키값 지워주기 
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
