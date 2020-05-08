package com.a2bo.info.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.a2bo.info.model.service.MenuInfoService;
import com.a2bo.info.model.vo.Review;
import com.a2bo.member.model.vo.Member;
import com.google.gson.Gson;

public class MenuInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuInfoService mService = new MenuInfoService();

	public MenuInfoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getRequestURI().substring(request.getContextPath().length());

		if (command.contains("addreview")) {
			addReview(request, response);
		} else if (command.contains("getreview")) {
			getReview(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void getReview(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int index = Integer.parseInt(request.getParameter("index"));
		String menuId = request.getParameter("menuId");

		List<Review> list = mService.getReview(menuId);
		List<Review> revList = new ArrayList<>();
		
		try {
			for (int i = 0; i < 5; i++) {
				int cnt = i % 5;
				int idx = cnt + (5 * index);
				revList.add(list.get(idx));
			}
		} catch (IndexOutOfBoundsException e) {
			
		}

		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		pw.write(gson.toJson(revList));
	}

	private void addReview(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int star = Integer.parseInt(request.getParameter("star"));
		String menuId = request.getParameter("menuId");
		int userId = ((Member) request.getSession().getAttribute("loginInfo")).getUserId();
		String content = request.getParameter("content");

		int res = mService.addReview(userId, menuId, content, star);
		PrintWriter pw = response.getWriter();
		pw.print(res);
	}
}
