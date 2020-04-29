package com.a2bo.review.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.a2bo.review.model.service.ReviewService;

/**
 * Servlet implementation class RevContr
 */
//@WebServlet("/RevContr")
public class RevContr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewService rs = new ReviewService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevContr() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void ReviewList(HttpServletRequest request) {
 	int currentPage = 1;
 	int cntPerPage = 5;
 	String orderby = "revId";
 	
 	if(request.getParameter("cPage")!=null) {
 		currentPage = Integer.parseInt(request.getParameter("cPage"));
 	}
 	
 	   Map<String, Object > res = rs.selectedRevList(orderby, currentPage, cntPerPage);

 	/*   mav.addObject("paging",res.get("paging"));
 	   mav.addObject("ndata",res.get("nlist"));
 	   mav.setView("board/boardList");
 	   return mav;
*/    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		boolean flg = false;
		
		/*do {
			
			switch(command) {
			
			case ("/review/menuInfo"): 
				break;
			case ("/review/menuInfo"):
				break;
			case ("/review/menuInfo"):
				break;
			case ("/review/menuInfo"):
				break;
			case ("/review/menuInfo"):
				break;
			case ("/review/menuInfo"):
				break;
			
			
			}
			
			
			
		}while(flg);*/
		
		if (command.equals("/review/menuInfo")) {
			menuInfo(request, response);
		}else if(command.equals("/review/")) {
			
		}
		/*
		request.setAttribute("price", price);
		request.setAttribute("menu", menu);*/
		
		RequestDispatcher view = request.getRequestDispatcher("views/menu/03_menuResult.jsp");
		
		//request에는 price와 menu 값이 들어가 있는 상태
		view.forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void menuInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/book/bookimage.jsp");

/*	blist = bs.searchBook();
	request.setAttribute("book", blist);*/
	
	// bookservice 단에서 가져온 값을 속성값으로 박아두고 넘기기

	rd.forward(request, response);
	}
	
}
