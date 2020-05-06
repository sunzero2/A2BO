package com.a2bo.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		} else if(command.contains("logout")) {
			logOut(request, response);
		} else if(command.contains("searchMem")) {
			String keyword = request.getParameter("keyword");
			int res = 0;
			
			if(keyword.equals("pw")) {
				res = 1;
			}
			
			request.setAttribute("keyword", res);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/search.jsp");
			view.forward(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 1. MethodName : login
	 2. ClassName : MemberController.java
	 3. Comment : 유저 로그인 메소드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 5. 1.
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/success.jsp");
		HttpSession session = request.getSession();
		String email = request.getParameter("userEmail");
		String pw = request.getParameter("userPwd");
		
		Member mem = mService.login(email, pw);
		if(mem != null) {
			session.setAttribute("loginInfo", mem);
		}
		
		rd.forward(request, response);
	}
	
	/**
	 1. MethodName : logOut
	 2. ClassName : MemberController.java
	 3. Comment : 유저 로그아웃 메소드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 5. 1.
	 */
	private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/main/main.jsp");
		HttpSession session = request.getSession();
		session.setAttribute("loginInfo", null);
		rd.forward(request, response);
	}
	
	/**
	 1. MethodName : join
	 2. ClassName : MemberController.java
	 3. Comment : 회원가입 메서드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 4. 24.
	 */
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/success.jsp");
		
		Member mem = new Member();
		mem.setPw(request.getParameter("userPw"));
		mem.setUserEmail(request.getParameter("userEmail"));
		mem.setNickname(request.getParameter("userName"));

		System.out.println("controller : " + mem.toString());
		if(mService.join(mem) > 0) {
			request.setAttribute("isSuccess", "가입을 축하드립니다!");
			request.setAttribute("sendMsg", "가입하신 계정과 비밀번호로 로그인해주세요.");
		} else {
			request.setAttribute("isSuccess", "가입 중 오류가 발생하였습니다.");
			request.setAttribute("sendMsg", "같은 오류 재발생 시 고객센터로 문의바랍니다.\n(ERR_CODE = USE001)");
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
