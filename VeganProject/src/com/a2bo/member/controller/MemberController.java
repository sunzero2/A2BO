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
		} else if(command.contains("searchmem")) {
			String keyword = request.getParameter("keyword");
			int res = 0;
			
			if(keyword.equals("pw")) {
				res = 1;
			}
			
			request.setAttribute("userEmail", null);
			request.setAttribute("userPw", null);
			request.setAttribute("keyword", res);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/search.jsp");
			view.forward(request, response);
		} else if (command.contains("searchId")) {
			searchId(request, response);
		} else if (command.contains("searchPw")) {
			searchPw(request, response);
		} else if (command.contains("changePw")) {
			changePw(request, response);
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
	 3. Comment : 회원가입 메소드
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
	 3. Comment : 회원가입 시 이메일 체크용 메소드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 4. 24.
	 */
	private void emailCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("userEmail");
		String res = mService.emailCheck(email);
		PrintWriter pw = response.getWriter();
		pw.write(res);
	}
	
	/**
	 1. MethodName :searchId
	 2. ClassName : MemberController.java
	 3. Comment : 회원의 계정 찾기용 메소드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 5. 8.
	 */
	private void searchId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String phone = request.getParameter("userPhone");
		String nickName = request.getParameter("nickName");
		
		
		String userEmail = mService.searchID(phone, nickName);
		
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("userPw", null);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/search.jsp");
		rd.forward(request, response);
	}
	
	
	/**
	 1. MethodName : searchPw
	 2. ClassName : MemberController.java
	 3. Comment : 회원의 비밀번호 변경을 위한 정보 입력용 메소드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 5. 8.
	 */
	private void searchPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userEmail = request.getParameter("userEmail");
		String nickName = request.getParameter("nickName");
		
		int res = mService.searchPw(userEmail, nickName);
		
		if(res > 0) {
			request.setAttribute("findId", userEmail);
		}
		request.setAttribute("userEmail", null);
		request.setAttribute("userPw", res);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/search.jsp");
		rd.forward(request, response);
	}
	
	/**
	 1. MethodName : changePw
	 2. ClassName : MemberController.java
	 3. Comment : 회원의 정보가 일치할 때 비밀번호 변경용 메소드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 5. 8.
	 */
	private void changePw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		String userPw = request.getParameter("userPw");
		
		int res = mService.changePw(userEmail, userPw);
		
		if(res > 0) {
			request.setAttribute("complatedChangePw", true);
		} else {
			request.setAttribute("complatedChangePw", false);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/search.jsp");
		rd.forward(request, response);
	}
}
