package com.a2bo.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a2bo.info.model.vo.Review;
import com.a2bo.member.model.service.MemberService;
import com.a2bo.member.model.vo.Member;
import com.a2bo.mypage.model.service.MypageService;
import com.google.common.base.CaseFormat;
import com.google.gson.Gson;

public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MypageService mService = new MypageService();
	
    public MypageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI().substring(request.getContextPath().length());
		RequestDispatcher rd = null;
		
		if(command.contains("main")) {
			rd = request.getRequestDispatcher("/WEB-INF/views/mypage/mypageMain.jsp");
			
			rd.forward(request, response);
		} else if(command.contains("inten")) {
			rd = request.getRequestDispatcher("/WEB-INF/views/mypage/vganInten.jsp");
			rd.forward(request, response);
		} else if(command.contains("privacy")) {
			rd = request.getRequestDispatcher("/WEB-INF/views/mypage/privacy.jsp");
			rd.forward(request, response);
		} else if(command.contains("changemember")) {
			changeMember(request, response);
		} else if(command.contains("changevl")) {
			changeVL(request, response);
		} else if(command.contains("myreview")) {
			myReview(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 1. MethodName : changeVL
	 2. ClassName : MypageController.java
	 3. Comment : 회원의 채식지향 변경 메소드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 4. 29.
	 */
	private void changeVL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/mypage/vganInten.jsp");
		HttpSession session = request.getSession();

		// select의 option 값을 가져옴
		String vl = request.getParameter("vLevel");
		
		// session 변경하기 위한 member 객체 선언
		Member member = (Member) session.getAttribute("loginInfo");
		
		// 매개변수로 vl이랑 userid 보내서 정상 작동됐는지 확인
		int res = mService.changeVL(vl, member.getUserId());
		
		// 0보다 크면 제대로 실행된 거니까 loginInfo 안에 들어갈 member의 값을 바꿔줌
		if(res > 0) {
			// member에는 vlid로 넣어줌
			member.setvLId(vl);
			session.setAttribute("loginInfo", member);
			
			// 사용자가 알아볼 수 있는 단어로 바꿔서 넣어줌.
			switch (vl) {
			case "FXT":
				vl = "플렉시테리언";
				break;
			case "POP":
				vl = "폴로페스코";
				break;
			case "PSC":
				vl = "페스코";
				break;
			case "POL":
				vl = "폴로";
				break;
			case "LOV":
				vl = "락토오보";
				break;
			case "LTO":
				vl = "락토";
				break;
			case "OVO":
				vl = "오보";
				break;
			case "VGN":
				vl = "비건";
				break;
			case "FTN":
				vl = "프루테리언";
				break;
			}
			request.setAttribute("setVLevel", vl);
			request.setAttribute("alertMsg", "정상적으로 변경되었습니다.");
		} else {
			request.setAttribute("alertMsg", "변경에 실패하였습니다. 다시 시도해주십시오.");
		}
		
		rd.forward(request, response);
	}
	
	
	/**
	 1. MethodName : changeMember
	 2. ClassName : MypageController.java
	 3. Comment : 회원정보 변경 메소드
	 4. 작성자 : 이혜영
	 5. 작성일 : 2020. 4. 27.
	 */
	private void changeMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/mypage/privacy.jsp");
		
		// 회원의 기존 정보를 가져올 수 있도록 session에 있는 loginInfo를 가져옴.
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginInfo");
		
		// 회원이 수정할 수 있는 정보는 닉네임, 비밀번호, 전화번호
		// 만약 회원이 닉네임을 수정하려고 한다면 비밀번호와 전화번호에는 null이 들어가 있을 것임
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String cell = request.getParameter("cell");
		
		// 가져온 값이 null일 경우 session의 loginInfo에 들어가있던 member 정보를 변수에 넣어줌
		if(nickname == null) {
			nickname = member.getNickname();
		}
		if(password == null) {
			password = member.getPw();
		}
		if(cell == null) {
			cell = member.getCell();
		}
		
		// update한 결과를 숫자로 넘겨받음
		int res = mService.changeMember(nickname, password, cell);
		
		// res가 0보다 크면 update문이 정상적으로 작동된 것임.
		// 회원의 기존 정보를 수정한 정보로 새로 고침하기 위해서 member의 값을 수정하고, loginInfo에 수정한
		// member 값을 넣으면, loginInfo에는 수정된 member의 값이 들어감.
		if(res > 0) {
			member.setNickname(nickname);
			member.setCell(cell);
			member.setPw(password);
			
			session.setAttribute("loginInfo", member);
			request.setAttribute("alertMsg", "회원 정보 수정에 성공하였습니다.");
		} else {
			// res가 0이면 update문이 제대로 실행하지 않은 것.
			// 회원에게 알림창으로 안내하기 위해서 request에 속성을 추가함.
			request.setAttribute("alertMsg", "회원 정보 수정에 실패하였습니다. 다시 시도해주십시오.");
		}
		
		rd.forward(request, response);
	}
	
	public void myReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int userId = ((Member)request.getSession().getAttribute("loginInfo")).getUserId();
		
		List<Review> list = mService.myReview(userId);
		
		Gson gson = new Gson();
		PrintWriter pw = response.getWriter();
		
		if(list != null) {
			pw.write(gson.toJson(list));
		} else {
			pw.print("none");
		}
	}
}
