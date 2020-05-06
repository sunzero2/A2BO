<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴 상세페이지</title>
<link rel="stylesheet" href="/vgan/resources/css/top.css"/>
<link rel="stylesheet" href="/vgan/resources/css/menuInfo.css"/>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.stars .fa{
color:#FF9800;
cursor:pointer;
}

</style>

</head>
<body>
<%@ include file="../top/top.jsp" %>
<br>
<hr>
<div class = menuInfo_TopWrapper> 
<img src= "/vgan/resources/image/${resMenuinfo.menuId}.jpg" class = "menuImg">
<div class = "menuInfoWrapper">
<p class = "menuName">${resMenuinfo.menuName}</p>
<p><br></p>

	<!-- 	<div class="stars"> 부모 
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>
         </div> -->

<p class = "starRate">평점.....$ ${resMenuinfo.revStarrate}/5점</p><br>
<p class = "menuinfoDeco1">X</p><br>
<br>
<p class = "menuLocation">${resMenuinfo.menuLocation}</p><br>
<p class = "restName">MADE BY.....$ ${resMenuinfo.restName}</p>
<p class = "restPhone">
<c:choose>
<c:when test="${resMenuinfo.restPhone ne null}">Call.....${resMenuinfo.restHour}</c:when>
<c:otherwise>전화를 받지 않습니다</c:otherwise>
</c:choose></p>
<p class = "restHour">
<c:choose>
<c:when test="${resMenuinfo.restHour ne null}">영업시간 ${resMenuinfo.restHour}</c:when>
<c:otherwise>영업시간 비공개</c:otherwise>
</c:choose>
</p>
<fmt:setLocale value="ko_kr"/>
<div class = "menuTitle"><fmt:formatNumber value="${resMenuinfo.menuPrice}" type="currency"/></div>
<div class = "veganlevel">${resMenuinfo.vLId}</div>
</div>
<br><br>
<div class = "revListWrapper">
<hr>
<h3 style="text-align: center"> REVIEW </h3>
<%@ include file="../reviewBoard/revList.jsp" %>
    <br>
    <hr> 
</div>
       <div class="paging"><!-- section pagination -->
                    <a href="javascript:;" class="nav first"><i class="fas fa-angle-double-left"></i></a>
                    <a href="javascript:;" class="nav prev"><i class="fas fa-angle-left"></i></a>
                    <a href="javascript:;" class="num active"><span>1</span></a>
                    <a href="javascript:;" class="num"><span>2</span></a>
                    <a href="javascript:;" class="num"><span>3</span></a>
                    <a href="javascript:;" class="num"><span>4</span></a>
                    <a href="javascript:;" class="num"><span>5</span></a>
                    <a href="javascript:;" class="nav next"><i class="fas fa-angle-right"></i></a>
                    <a href="javascript:;" class="nav last"><i class="fas fa-angle-double-right"></i></a>
    </div><!-- // section pagination -->
</div>

<form action="/vgan/menuinfo/revup" method="post">
         
        <br><br>
        <div class="revTitle">
         <input type="text" name="revTitle" size="50px" placeholder="제목을 입력하세요" />
         <div class="stars"> <!-- 부모 --> 
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>
         </div>
         <input type="hidden" class="ratingValue" name="ratingValue">
         <script>
         const stars=document.querySelector(".stars").children;
         //const ratingValue= ${request.revStarrate};
         const ratingValue=document.querySelector(".ratingValue");
         let index;
         
         for(let i=0; i<stars.length; i++){
        	 stars[i].addEventListener("mouseover", function(){
        		 
        		 for(let j=0; j<stars.length; j++){
        			 stars[j].classList.remove("fa-star")
        			 stars[j].classList.add("fa-star-o") 
        		 }
        		 for(let j=0; j<=i; j++){
        			 stars[j].classList.remove("fa-star-o")
        			 stars[j].classList.add("fa-star")
        		 }
        	 })
        	 stars[i].addEventListener("click",function(){
        		 ratingValue.value=i+1;
        		 index=i;
        	 })
        	 stars[i].addEventListener("mouseout", function(){
        		 
        		 for(let j=0; j<stars.length; j++){
        			 stars[j].classList.remove("fa-star")
        			 stars[j].classList.add("fa-star-o") 
        		 }
        		 for(let j=0; j<=index; j++){
        			 stars[j].classList.remove("fa-star-o")
        			 stars[j].classList.add("fa-star")
        		 }
         }
         </script>
         
         </div>
        <textarea style="width: 500px;" name="revContent" rows="10" cols="50" placeholder="500자 이하로 작성하세요"></textarea>
        <input type="hidden" name="menuId" value="${resMenuinfo.menuId}">
        <div class="submit">
            <input class="writebutton" type="submit" value="WRITE">
        </div>
  
</form>

//KAKAO MAP API

</body>
</html>