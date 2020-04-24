package com.a2bo.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.a2bo.member.model.service.MemberService;
import com.a2bo.member.model.vo.Member;

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
	
	/**
	 1. MethodName : join
	 2. ClassName : MemberController.java
	 3. Comment : 회원가입 메서드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 4. 24.
	 */
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/main.jsp");
		String name = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		String pw = request.getParameter("userPw");
		
		Member mem = new Member();
		mem.setPw(pw);
		mem.setUserEmail(email);
		mem.setNickname(name);
		
		int res = mService.join(mem);
		if(res > 0) {
			System.out.println("성공");
			request.setAttribute("isSuccess", "true");
			request.setAttribute("alertMsg", "회원가입에 성공하였습니다. 다시 로그인해주세요.");
		} else {
			System.out.println("실패");
			request.setAttribute("inSuccess", "false");
			request.setAttribute("alertMsg", "회원가입에 실패하였습니다. 다시 시도해주세요.");
		}
		
		rd.forward(request, response);
	}
	
	/**
	 1. MethodName : emailCheck
	 2. ClassName : MemberController.java
	 3. Comment : 회원가입 시 이메일 체크용 메서드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 4. 24.
	 */
	private void emailCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("userEmail");
		String res = mService.emailCheck(email);
		PrintWriter pw = response.getWriter();
		pw.write(res);
	}
}
