<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
<title>Insert title here</title>
<link rel="stylesheet" href="http://192.168.10.20:8787/vgan/resources/css/top.css" />
<link rel="stylesheet" href="http://192.168.10.20:8787/vgan/resources/css/myPageMain.css"/>
<link rel="stylesheet" href="http://192.168.10.20:8787/vgan/resources/css/main.css"/>
</head>
<body onload="getReview();">
	<%@ include file="../top/top.jsp" %>
	<%@ include file="mypageNavi.jsp" %>
	
	<%-- <c:if test="${loginInfo == null}">
		<script>
			alert("로그인이 종료되어 메인페이지로 이동합니다.");
			location.href = "http://localhost:8787/vgan/welcome";
		</script>
	</c:if> --%>
	
	<div class="mypageConWrapper">
		<div class="mypageTitle">나의 리뷰</div>
		<div class="myReviewBody">
			<ul class="media-list">
			</ul>  
		</div>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
	<script src="http://192.168.10.20:8787/vgan/resources/js/top.js"></script>
	<script>
		var myId = ${loginInfo.userId};
	</script>
	<script src="http://192.168.10.20:8787/vgan/resources/js/myReview.js"></script>
</body>
</html>