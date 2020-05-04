package com.a2bo.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a2bo.review.model.service.ReviewService;
import com.a2bo.review.model.vo.Review;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
	
		//카드에서 서브밋에서 리퀘스트객체로 불러온 파라미터밸류스 스트링으로 넣기
		if(command.contains("menuInfo")) {
			
			Map<String,Object> resMenuinfo= new HashMap<>();
			 view = request.getRequestDispatcher("WEB-INF/views/menuInfo/menuInfo.jsp");
			//request에는 main.jsp에서 뿌려준 메뉴와 레스토랑의 값이 들어가 있는 상태
			 resMenuinfo= request.getParameterMap();
			 request.setAttribute("request", resMenuinfo);
			 view.forward(request, response);
			 
		}else if(command.contains("revUp")){/*
			Review revUp = (Review)request.getParameterMap();
			String menuid = revUp.getMenuId();
			int res = rs.reviewUpload(revUp);
			if(res>0) {
				List revList = rs.selectedRevList(menuid, currentPage, cntPerPage);
				session.setAttribute("review", revList);
				request.setAttribute("alert", "게시글이 정상적으로 등록되었습니다.");
			}else {
				request.setAttribute("alert", "게시글이 등록되지 않았습니다. 다시 작성해주세요.");
			}
		view.forward(request, response);
		*/}else if(command.contains("selectRevList")){
			 view = request.getRequestDispatcher("WEB-INF/views/reviewBoard/revList.jsp");

		}
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
