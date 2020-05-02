package com.a2bo.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import com.a2bo.main.model.service.MainService;
import com.a2bo.main.model.vo.MainVlv;
import com.google.common.collect.HashBiMap;

public class MainController extends HttpServlet {
   private static final long serialVersionUID = 1L;
    private MainService mService = new MainService();   
   

    public MainController() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String uri = request.getRequestURI();   //위에 떠있는 주소
      String conPath = request.getContextPath();
      String command = uri.substring(conPath.length());
      RequestDispatcher rd = null;
      //System.out.println("컨트롤러에서 커맨드 " +  command.contains("searchingVg"));
      if(command.contains("searchingVg")) {
         searchingVg(request,response);
      }else if(command.contains("searchingMenu")) {
         searchingMenu(request,response);
      }
      //메뉴보기 버튼 꼭 만들기
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

   
   private void searchingVg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html; charset=utf-8");
//	  System.out.println("여기까지는 왔나?");
      List<Integer> list = new ArrayList<>();
      RequestDispatcher rd = null;
      PrintWriter pw = response.getWriter();
      HttpSession session = request.getSession();
      String stringList = request.getParameter("str");
      
      //ajax로 넘어온 stringList 숫자들이 한번에 저장 되어서 배열로 한글자씩 담는 코드
      String[] ingList;
      ingList = stringList.split("");
//      System.out.println("컨트롤러 배열  ingList " + ingList);
      
      
      String myLevel ="";
     
      for (String ing : ingList) {
    	  list.add(Integer.parseInt(ing));
      }
      List<MainVlv> vgList = mService.searchingVg(list);
//      System.out.println("컨트롤러 단에서 리스트 " + list);
//      System.out.println("컨트롤러 단에서 리스트 투스트링" + list.toString());
//      System.out.println("컨트롤러 단에서 리스트 사이즈 " + list.size());
      
      
      if(vgList.toString().contains("FTN")) {
         myLevel = "프루테리언";
      }else if(vgList.toString().contains("VGN")) {
         myLevel = "비건";
      }else if(vgList.toString().contains("OVO")) {
         myLevel = "오보";
      }else if(vgList.toString().contains("LTO")) {
         myLevel = "락토";
      }else if(vgList.toString().contains("LOV")) {
         myLevel = "락토오보";
      }else if(vgList.toString().contains("POL")) {
         myLevel = "폴로";
      }else if(vgList.toString().contains("PSC")) {
         myLevel = "페스코";
      }else if(vgList.toString().contains("POP")) {
         myLevel = "폴로페스코";
      }else if(vgList.toString().contains("FXT")) {
         myLevel = "플렉시테리언";
      }
//      System.out.println("컨트롤러 단에서 myLevel " + myLevel);
      
      
      request.setAttribute("myLevel", myLevel);
      
      
//      System.out.println("컨트롤러 단에서 vgList " + vgList);
      Cookie cookie = new Cookie("myLevel", myLevel);
      response.addCookie(cookie);
      pw.println("<h1>당신의 비건 단계는 " + myLevel + "입니다~</h1>");
      
      pw.flush();
      pw.close();
      
//      rd = request.getRequestDispatcher("/WEB-INF/views/main/main.jsp");
//      rd.forward(request, response); 
      	
   }
   
   private void searchingMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html; charset=utf-8");
      String myLevel = "";
      String myLevelId = "";
      RequestDispatcher rd = null;
      PrintWriter pw = response.getWriter();
      HttpSession session = request.getSession();
      Cookie[] cookies = request.getCookies();
      for (Cookie cookie : cookies) {
         if(cookie.getName().equals("myLevel")) {
            myLevel = cookie.getValue();
         }
      }
      
      // 쿠키 ? 
      if(myLevel.toString().contains("프루테리언")) {
         myLevelId = "FTN";
      }else if(myLevel.toString().contains("비건")) {
         myLevelId = "VGN";
      }else if(myLevel.toString().contains("오보")) {
         myLevelId = "OVO";
      }else if(myLevel.toString().contains("락토")) {
         myLevelId = "LTO";
      }else if(myLevel.toString().contains("락토오보")) {
         myLevelId = "LOV";
      }else if(myLevel.toString().contains("폴로")) {
         myLevelId = "POL";
      }else if(myLevel.toString().contains("페스코")) {
         myLevelId = "PSC";
      }else if(myLevel.toString().contains("폴로페스코")) {
         myLevelId = "POP";
      }else if(myLevel.toString().contains("플렉시테리언")) {
         myLevelId = "FXT";
      }
         
      List<Map<String, Object>> menu = mService.searchingMenu(myLevelId);
      System.out.println("컨트롤러에서 서칭메뉴 myLevel " + myLevel) ;
      System.out.println("컨트롤러에서 서칭메뉴 myLevelId " + myLevelId) ;
      System.out.println("컨트롤러에서 서칭메뉴 menu " + menu);
      
      request.setAttribute("myLevelId", myLevelId);
            
      System.out.println("컨트롤러에서 맵 메뉴" + menu);
//      rd = request.getRequestDispatcher("/WEB-INF/views/main/main.jsp");
//      rd.forward(request, response); 
//      pw.println("<div class='menuImage'><img src='http://placehold.it/245x230'></div><div class='menuInfo'><div class='menuName'>메뉴 이름 : " + menu + "</div><div class='menuPoint'>별점 : </div><div class='menuAd'>주소 : </div><button class='ingBtn' onclick='menuInfoBox()'>버튼 상세보기</button>\"\r\n" + 
//      				"+ <a href='https://www.saramin.co.kr/zf_user/' target='menuIf'></a></div></div>");
      pw.println("<h3>" + menu+ "</h3>");
      pw.flush();
      pw.close();
      
      
   }

   
}