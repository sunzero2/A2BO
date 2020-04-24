package com.a2bo.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MypageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI().substring(request.getContextPath().length());
		RequestDispatcher rd = null;
		
		if(command.contains("main")) {
			rd = request.getRequestDispatcher("/WEB-INF/views/mypage/mypageMain.jsp");
		} else if(command.contains("inten")) {
			rd = request.getRequestDispatcher("/WEB-INF/views/mypage/vganInten.jsp");
		} else if(command.contains("privacy")) {
			rd = request.getRequestDispatcher("/WEB-INF/views/mypage/privacy.jsp");
		}
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	// 내가 찜한 카드 가져오는 메서드
	private void likeMenuList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 찜하기 삭제 메서드
	private void removeLikeMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 회원의 채식지향 변경 메서드
	private void changeVL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 회원정보변경 메서드
	private void changeMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
