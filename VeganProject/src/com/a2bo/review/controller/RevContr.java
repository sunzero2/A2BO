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

import com.a2bo.member.model.vo.Member;
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

<<<<<<< HEAD
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
	
		//카드에서 서브밋에서 리퀘스트객체로 불러온 파라미터밸류스 스트링으로 넣기
		if(command.contains("menuinfo")) {
			
			Map<String,Object> resMenuinfo= new HashMap<>();
			 view = request.getRequestDispatcher("/WEB-INF/views/menuInfo/menuInfo.jsp");
			//request에는 main.jsp에서 뿌려준 메뉴와 레스토랑의 값이 들어가 있는 상태
			 resMenuinfo= request.getParameterMap();
			 request.setAttribute("resMenuinfo", resMenuinfo);
			 
			 Map<String,Object> revList= new HashMap<>();
			 revList = ReviewList(request);
			 request.setAttribute("revList", revList);
			 
			 view.forward(request, response);
			 
		}else if(command.contains("revup")){
			Review review = new Review();
			review = revUp(request);
			view = request.getRequestDispatcher("/WEB-INF/views/menuInfo/menuInfo.jsp");
			request.setAttribute("reviewList", review);				
			view.forward(request, response);
			
		}else if(command.contains("ReviewList")) {
			
			Map<String,Object> revList = ReviewList(request);
			view = request.getRequestDispatcher("/WEB-INF/views/menuInfo/menuInfo.jsp");
			session.setAttribute("revList", revList);
			view.forward(request, response);
			
		}
		
	}
	
	public Review revUp(HttpServletRequest request) {
		Review review = new Review();
		Member m = (Member)request.getSession().getAttribute("loginInfo");
		
		review.setMenuId(request.getParameter("menuId"));
		review.setReviewContent(request.getParameter("revContent"));
		review.setReviewStar(Integer.parseInt(request.getParameter("revStar")));
		review.setReviewTitle(request.getParameter("revTitle"));
		review.setReviewWriter(m.getUserId());
		
		if(rs.reviewUpload(review)>0) {
			request.setAttribute("alert", "게시글이 정상적으로 등록되었습니다.");
		}else {
			request.setAttribute("alert", "게시글이 등록되지 않았습니다. 다시 작성해주세요.");
		}
		return review;
	}
	
	public int revStarrate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int starrate= 0;
		String menuid = request.getParameter("menuId");
		starrate = rs.getStarrate(menuid);
		
		RequestDispatcher view = null;
		
		view = request.getRequestDispatcher("WEB-INF/views/menuInfo/menuInfo.jsp");
		request.setAttribute("starrate", starrate);
		view.forward(request, response);
		return starrate;
	}
	
=======
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      
      String uri = request.getRequestURI();
      String conPath = request.getContextPath();
      String command = uri.substring(conPath.length());
      RequestDispatcher view = null;
      HttpSession session = request.getSession();
   
      //카드에서 서브밋에서 리퀘스트객체로 불러온 파라미터밸류스 스트링으로 넣기
      if(command.contains("menuinfo")) {
         
         Map<String,Object> resMenuinfo= new HashMap<>();
          view = request.getRequestDispatcher("/WEB-INF/views/menuInfo/menuInfo.jsp");
         //request에는 main.jsp에서 뿌려준 메뉴와 레스토랑의 값이 들어가 있는 상태
          resMenuinfo= request.getParameterMap();
          request.setAttribute("resMenuinfo", resMenuinfo);
          
          Map<String,Object> revList= new HashMap<>();
          revList = ReviewList(request);
          request.setAttribute("revList", revList);
          
          view.forward(request, response);
          
      }else if(command.contains("revup")){
         Review review = new Review();
         review = revUp(request);
         view = request.getRequestDispatcher("/WEB-INF/views/menuInfo/menuInfo.jsp");
         request.setAttribute("reviewList", review);            
         view.forward(request, response);
         
      }else if(command.contains("ReviewList")) {
         
         Map<String,Object> revList = ReviewList(request);
         view = request.getRequestDispatcher("/WEB-INF/views/menuInfo/menuInfo.jsp");
         session.setAttribute("revList", revList);
         view.forward(request, response);
         
      }
      
   }
   
   public Review revUp(HttpServletRequest request) {
      Review review = new Review();
      Member m = (Member)request.getSession().getAttribute("loginInfo");
      
      review.setMenuId(request.getParameter("menuId"));
      review.setReviewContent(request.getParameter("revContent"));
      review.setReviewStar(Integer.parseInt(request.getParameter("revStar")));
      review.setReviewTitle(request.getParameter("revTitle"));
      review.setReviewWriter(m.getUserId());
      
      if(rs.reviewUpload(review)>0) {
         request.setAttribute("alert", "게시글이 정상적으로 등록되었습니다.");
      }else {
         request.setAttribute("alert", "게시글이 등록되지 않았습니다. 다시 작성해주세요.");
      }
      return review;
   }
   
   public int revStarrate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int starrate= 0;
      String menuid = request.getParameter("menuId");
      starrate = rs.getStarrate(menuid);
      
      RequestDispatcher view = null;
      
      view = request.getRequestDispatcher("WEB-INF/views/menuInfo/menuInfo.jsp");
      request.setAttribute("starrate", starrate);
      view.forward(request, response);
      return starrate;
   }
   
>>>>>>> adc1462a6f783df957342f378535d1428cbfbead
    public Map<String,Object> ReviewList(HttpServletRequest request) {
    int currentPage = 1;
    int cntPerPage = 5;
    String orderby = "reviewNo";
    
    if(request.getParameter("cPage")!=null) {
       currentPage = Integer.parseInt(request.getParameter("cPage"));
    }
    
    Map<String,Object> res = rs.selectedRevList(orderby, currentPage, cntPerPage);

    return res;
    }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

   
}