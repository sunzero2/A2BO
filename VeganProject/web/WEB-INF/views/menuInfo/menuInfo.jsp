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
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.stars .fa {
margin-left:3px;
color:#FF9800;
cursor:pointer;
}
.menuInfoWrapper{
position:relative;
margin-top:5%;
left:3%;
text-align:center;
}
.menuborder{
position:absolute;
left:20%;
}
.detailinfo{
position:relative;
text-align:left;
left:35%;
}
.revListWrapper{
postition:relative;
text-align:center;
margin-left:6%;
}
.inputTitle{
width:60%;
}
.stars2{
width:30%}
</style>
</head>
<body>
<%@ include file="../top/top.jsp" %>
<br>
<hr>
<hr>
<img src= "/vgan/resources/image/MenuinfoBorder.png" class = "menuborder">

<div class = "menuInfoWrapper">
<span class = "menuName"><h1>${resMenuinfo.menuName}메뉴이름</h1></span>
		<span class="stars" id="stars1">
            <span class="fa fa-star-o" value="1"></span>
            <span class="fa fa-star-o" value="2"></span>
            <span class="fa fa-star-o" value="3"></span>
            <span class="fa fa-star-o" value="4"></span>
            <span class="fa fa-star-o" value="5"></span>
            <span>${resMenuinfo.revStarrate}/5점</span>
         </span><br>
        	
<img src= "/vgan/resources/image/menuLine1.png" class = "nameline">
<br>

<div class="detailinfo">
<p class = "menuLocation">${resMenuinfo.menuLocation}</p><br>
<p class = "restName">MADE BY. . . . . . . . . .$ ${resMenuinfo.restName}</p>
<p class = "restPhone">
<c:choose>
<c:when test="${resMenuinfo.restPhone ne null}">Call. . . . . . . . . .$ ${resMenuinfo.restPhone}</c:when>
<c:otherwise>Call. . . . . . . . . .$ 전화 예약을 받지 않습니다</c:otherwise>
</c:choose></p>
<p class = "restHour">
<c:choose>
<c:when test="${resMenuinfo.restHour ne null}">영업시간. . . . . . . . . .$ ${resMenuinfo.restHour}</c:when>
<c:otherwise>영업시간. . . . . . . . . .$ 비공개</c:otherwise>
</c:choose>
</p>
<fmt:setLocale value="ko_kr"/>
<div class = "menuTitle"><fmt:formatNumber value="${resMenuinfo.menuPrice}" type="currency"/></div>
<div class = "veganlevel">비건단계. . . . . . . . . .$ ${resMenuinfo.vLId}</div>
</div>
</div>
<br><br>
<div class = "revListWrapper">
<img src= "/vgan/resources/image/menuline2.jpg" class = "revlinetop">
<h1>R E V I E W</h1>
<img src= "/vgan/resources/image/menuline2.jpg" class = "revlinebottom">
<div class = "revList"><%@ include file="../reviewBoard/revList.jsp" %></div>
<br>

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

<img src= "/vgan/resources/image/menuline2.jpg" class = "revlinebottom">
</div>

        <br><br>
	     
<form action="/vgan/revup" method="post" class ="fffform">
        <div class="revTitle">
	         <input type="text" name="revTitle" size="50px" placeholder="제목을 입력하세요" >
         	<span class="stars" id="stars2">
	            <span class="fa fa-star-o" value="1"></span>
	            <span class="fa fa-star-o" value="2"></span>
	            <span class="fa fa-star-o" value="3"></span>
	            <span class="fa fa-star-o" value="4"></span>
	            <span class="fa fa-star-o" value="5"></span>
	        </span> 
       </div>

	 <input type="hidden" class="ratingValue" name="ratingValue"/>
         <br>
        <textarea style="width: 500px;" name="revContent" rows="10" cols="50" placeholder="500자 이하로 작성하세요"></textarea>
        <input type="hidden" name="menuId" value="${resMenuinfo.menuId}"/>
        <div class="submit">
        <br>
            <input class="writebutton" type="submit" value="WRITE">
        </div>
</form>

<script src="https://code.jquery.com/jquery-3.4.1.js"
		integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
		crossorigin="anonymous" type="text/javascript"></script>
		
		<script type="text/javascript">
		
         var stars = document.querySelector("#stars1").children;
         var stars2 = document.querySelector("#stars2").children;
        
         //const ratingValue= ${request.revStarrate};
         var ratingValue=document.querySelector(".ratingValue");
         
         var content;	// 제목
         var count;	// 별
         
         for(var i=0; i < stars.length; i++){
        	 stars[i].addEventListener("mouseover", function(e){
        		
        		 for(var j=0; j<stars.length; j++){
        			 stars[j].classList.remove("fa-star");
        			 stars[j].classList.add("fa-star-o"); 
        		 }
        		 
        		 count = e.target.getAttribute("value");
        		 
        		 for(var j=0; j < count; j++){
        			 stars[j].classList.remove("fa-star-o");
        			 stars[j].classList.add("fa-star");
        		 }
        	 })
         }
         
         
         console.log(stars2.length);
         
         for(var i=0; i < stars2.length; i++){
        	 console.dir('out');
        	 console.dir(stars2[i]);
        	 
        	 stars2[i].addEventListener("mouseover", function(e){
        		
        		 for(var j=0; j < stars2.length; j++){
        			 console.dir('in');
        			 console.dir(stars2[j]);
        			 stars2[j].classList.remove("fa-star");
        			 stars2[j].classList.add("fa-star-o"); 
        		 }
        		 
        		 count = e.target.getAttribute("value");
        		 
        		 for(var j=0; j < 3; j++){
        			 stars2[j].classList.remove("fa-star-o");
        			 stars2[j].classList.add("fa-star");
        		 }
        		 
        	 })
         }
         
       /*   document.querySelector('.go').addEventListener('click' , function() {
        	 title= document.querySelector('.title').textContent;
        	 content = document.querySelector('.revContent').textContent;
        	 
        	  $.ajax({
        		 type:"POST" ,
        		 url:"/vgan/revup" ,
        		 data : {
        			 title : title ,
        			 content : content ,
        			 count : count
        		 }
        	 
        	 }) 
        	 
         }) */
         </script>

</body>

</html>