package com.a2bo.member.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.a2bo.member.model.service.MemberService;

public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService mService = new MemberService();
    
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ContextPath는 ContextRoot임.
		// 우리의 프로젝트에서는 /vgan이 ContextRoot가 됨
		// getRequestURI는 ContextPath를 포함한 사용자의 요청 URI를 보냄
		// 만약 사용자가 http://localhost:8787/vgan/member/join로 접속하려고 한다면
		// /vgan/member/join이 RequestURI임
		String command = request.getRequestURI().substring(request.getContextPath().length());
		
		// 이렇게 contains로 해도 되고, equals로 해도 됨
		// contains면 분기가 나눠지는 단어로 하면 되고, equals는 member/login, member/join 이런 식으로 해야 됨
		if(command.contains("login")) {
			login(request, response);
		} else if(command.contains("join")) {
			join(request, response);
		} else if(command.contains("goin")) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
			view.forward(request, response);
		} else if(command.contains("check")) {
			emailCheck(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private String emailCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String res = mService.emailCheck(request.getParameter("userEmail"));
		return res;
	}
}
