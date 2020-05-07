package com.a2bo.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.a2bo.main.model.service.MainService;
import com.a2bo.main.model.vo.MainVlv;
import com.google.gson.Gson;

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainService mService = new MainService();

	public MainController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI(); // 위에 떠있는 주소
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		RequestDispatcher rd = null;
		if (command.contains("searchingvg")) {
			searchingVg(request, response);
		} else if (command.contains("searchingmenu")) {
			searchingMenu(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 1. MethodName : searchingVg 2. ClassName : MainController.java 3. Comment :
	 * 회원의 채식지향을 찾아주는 메소드 4. 작성자 : 이혜영 5. 작성일 : 2020. 5. 8.
	 */
	private void searchingVg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		List<Integer> list = new ArrayList<>();
		RequestDispatcher rd = null;
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String stringList = request.getParameter("str");
		String[] ingList;
		ingList = stringList.split("");
		String myLevel = "";

		for (String ing : ingList) {
			list.add(Integer.parseInt(ing));
		}
		List<MainVlv> vgList = mService.searchingVg(list);

		if (vgList.toString().contains("FTN")) {
			myLevel = "프루테리언";
		} else if (vgList.toString().contains("VGN")) {
			myLevel = "비건";
		} else if (vgList.toString().contains("OVO")) {
			myLevel = "오보";
		} else if (vgList.toString().contains("LTO")) {
			myLevel = "락토";
		} else if (vgList.toString().contains("LOV")) {
			myLevel = "락토오보";
		} else if (vgList.toString().contains("POL")) {
			myLevel = "폴로";
		} else if (vgList.toString().contains("PSC")) {
			myLevel = "페스코";
		} else if (vgList.toString().contains("POP")) {
			myLevel = "폴로페스코";
		} else if (vgList.toString().contains("FXT")) {
			myLevel = "플렉시테리언";
		}

		request.setAttribute("myLevel", myLevel);
		Cookie cookie = new Cookie("myLevel", myLevel);
		response.addCookie(cookie);
		pw.println("<h2 class='section-heading text-uppercase'>당신을 위한 추천 메뉴!</h2>"
				+ "<h3 id='levelInfo' class='section-subheading text-muted'>오늘 당신의 선택 : " + myLevel
				+ " 메뉴를 골라보세요!</h3>");
		pw.flush();
		pw.close();
	}

	/**
	 * 1. MethodName : searchingMenu 2. ClassName : MainController.java 3. Comment :
	 * 회원의 채식지향에 따른 메뉴 추천 메소드 4. 작성자 : 이혜영 5. 작성일 : 2020. 5. 8.
	 */
	private void searchingMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String myLevel = "";
		String myLevelId = "";
		RequestDispatcher rd = null;
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("myLevel")) {
				myLevel = cookie.getValue();
			}
		}

		// 쿠키 ?
		if (myLevel.toString().equals("프루테리언")) {
			myLevelId = "FTN";
		} else if (myLevel.toString().equals("비건")) {
			myLevelId = "VGN";
		} else if (myLevel.toString().equals("오보")) {
			myLevelId = "OVO";
		} else if (myLevel.toString().equals("락토")) {
			myLevelId = "LTO";
		} else if (myLevel.toString().equals("락토오보")) {
			myLevelId = "LOV";
		} else if (myLevel.toString().equals("폴로")) {
			myLevelId = "POL";
		} else if (myLevel.toString().equals("페스코")) {
			myLevelId = "PSC";
		} else if (myLevel.toString().equals("폴로페스코")) {
			myLevelId = "POP";
		} else if (myLevel.toString().equals("플렉시테리언")) {
			myLevelId = "FXT";
		}

		List<Map<String, Object>> menu = mService.searchingMenu(myLevelId);
		Gson gson = new Gson();
		pw.write(gson.toJson(menu));
	}
}