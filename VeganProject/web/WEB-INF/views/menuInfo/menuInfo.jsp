<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   <%@page import="com.a2bo.review.model.vo.Review"%>
   <%@page import="com.a2bo.review.model.vo.Restaurant"%>
   <%@page import="com.a2bo.main.model.vo.MainMenu"%>
   <%@page import="com.a2bo.map.model.vo.Map"%>
  
<%
	Review review = (Review) request.getAttribute("review");
	MainMenu menu = (MainMenu) request.getAttribute("menuinfo");
	Map map = (Map) request.getAttribute("map");
	Restaurant rest = (Restaurant) request.getAttribute("restId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴 상세페이지</title>
<link rel="stylesheet" href="/vgan/resources/css/top.css"/>
</head>
<body>
<%@ include file="../top/top.jsp" %>

<hr>
<div class = menuInfoTopWrapper>
<div class ="menuImg">
<img src= "/vgan/resources/image/${request.menuId}.img">
</div>
<div class = "menuInfoWrapper">
<div class = "InfoPageTitle">${request.menuName}</div>
<div class = "starRate">평점..... ${reivew.revStarrate}/5점</div><br>
<div class = "menuinfoDeco1">X</div><br>
<br>
<div class = "menuLocation">${map.menuLocation}</div><br>
<div class = "restName">MADE BY..... ${rest.restName}</div>
<div class = "restPhone">
<c:choose>
<c:when test="${rest.restPhone ne null}">Call..... ${rest.restHour}</c:when>
<c:otherwise>전화를 받지 않습니다</c:otherwise>
</c:choose>
<div class = "restHour">
<c:choose>
<c:when test="${rest.restHour ne null}">영업시간 ${rest.restHour}</c:when>
<c:otherwise>영업시간 비공개</c:otherwise>
</c:choose>
</div>
<div class="지점명">
<c:choose>
<c:when test="${rest.restBranch ne null}">지점명 ${rest.restBranch}</c:when>
<c:otherwise>-</c:otherwise>
</c:choose>
</div>
<br>
<fmt:setLocale value="ko_kr"/>
<div class = "menuTitle"><fmt:formatNumber value="${menu.menuPrice}" type="currency"/></div>
<div class = "veganlevel">${menu.vLId}</div>
</div>
</div>
</div>
<hr>
<h2>Review</h2>
<div class = "revWrapper">
<%@ include file="../reviewBoard/revList.jsp" %>
       <div class="paging"><!-- section pagination -->
                    <a href="javascript:;" class="nav first"><i class="fas fa-angle-double-left"></i></a>
                    <a href="javascript:;" class="nav prev"><i class="fas fa-angle-left"></i></a>
                    <a href="javascript:;" class="num active"><span>1</span></a>
                    <a href="javascript:;" class="num"><span>2</span></a>
                    <a href="javascript:;" class="num"><span>3</span></a>
                    <a href="javascript:;" class="num"><span>4</span></a>
                    <a href="javascript:;" class="num"><span>5</span></a>
                    <a href="javascript:;" class="num"><span>6</span></a>
                    <a href="javascript:;" class="num"><span>7</span></a>
                    <a href="javascript:;" class="num"><span>8</span></a>
                    <a href="javascript:;" class="num"><span>9</span></a>
                    <a href="javascript:;" class="num"><span>10</span></a>
                    <a href="javascript:;" class="nav next"><i class="fas fa-angle-right"></i></a>
                    <a href="javascript:;" class="nav last"><i class="fas fa-angle-double-right"></i></a>
    </div><!-- // section pagination -->
</div>







</body>
</html>