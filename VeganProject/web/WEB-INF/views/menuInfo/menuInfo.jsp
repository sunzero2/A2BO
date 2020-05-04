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
</head>
<body>
<%@ include file="../top/top.jsp" %>
<br>
<hr>
<div class = menuInfo_TopWrapper>
<img src= "/vgan/resources/image/${request.menuName}.jpg" class = "menuImg">
<div class = "menuInfoWrapper">
<p class = "menuName">${request.menuName}</p>
<p><br></p>
<p class = "starRate">평점.....$ ${request.revStarrate}/5점</p><br>
<p class = "menuinfoDeco1">X</p>
<p class = "restName">MADE BY.....$ ${request.restName}</p>
<p class = "menuLocation">주소.....$ ${request.menuLocation}</p><br>
<p class = "restPhone">
<c:choose>
<c:when test="${request.restPhone ne null}">Call..... ${request.restHour}</c:when>
<c:otherwise>전화예약을 받지 않습니다</c:otherwise>
</c:choose></p>
<p class = "restHour">
<c:choose>
<c:when test="${request.restHour ne null}">영업시간 ${request.restHour}</c:when>
<c:otherwise>영업시간 비공개</c:otherwise>
</c:choose>
</p>
<fmt:setLocale value="ko_kr"/>
<div class = "menuTitle"><fmt:formatNumber value="${request.menuPrice}" type="currency"/></div>
</div>
<br><br>
<div class = "revListWrapper">
<hr>
<h3 style="text-align: center"> REVIEW </h3>
<%@ include file="../reviewBoard/revList.jsp" %>

    <br>
    <hr>

    <div id="buttonWrapper">
        <i class="fas fa-chevron-left"></i>
        <button class="prev">prev</button>

        <button class="next">next</button>
        <i class="fas fa-chevron-right"></i>
    </div>
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

<form action="menuinfo.do" method="post">
      
      <script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous">
        $('#star a').click(function(){ $(this).parent().children("a").removeClass("on"); 
        $(this).addClass("on").prevAll("a").addClass("on"); 
        $(this).attr("value"); 
        });
        </script>
        <br><br>
        <div class="revTitle">
         <input type="text" name="revTitle" size="50px" placeholder="제목을 입력하세요" />
         <span id="star" name="starRate"> <!-- 부모 --> 
            <a href="#" value="1">★</a> <!-- 자식들--> 
            <a href="#" value="2">★</a> 
            <a href="#" value="3">★</a> 
            <a href="#" value="4">★</a> 
            <a href="#" value="5">★</a> 
         </span>
         </div>
        <textarea style="width: 500px;" name="revContent" aria-required="true" rows="10" cols="50" placeholder="500자 이하로 작성하세요"></textarea>
        <div class="submit">
            <input class="writebutton" type="submit" value="WRITE">
        </div>
  
</form>

</body>
</html>