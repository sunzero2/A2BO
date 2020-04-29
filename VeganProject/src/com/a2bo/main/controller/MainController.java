package com.a2bo.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a2bo.main.model.service.MainService;
import com.a2bo.main.model.vo.MainVlv;

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MainService mService = new MainService();   
	
    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		RequestDispatcher rd = null;
		
		if(command.contains("searchingVg")) {
			searchingVg(request,response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private void searchingVg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Integer> list = new ArrayList<>();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/main.jsp");
		HttpSession session = request.getSession();
		String[] ingList = request.getParameterValues("ing");
		for (String ing : ingList) {
			list.add(Integer.parseInt(ing));
		}
		
		System.out.println(list.toString());
		//MainVlv mvl = mService.searchingVg(list);
		
		
		
		
	}
	
}
