<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
<title>Insert title here</title>
<link rel="stylesheet" href="/vgan/resources/css/top.css" />
<link rel="stylesheet" href="/vgan/resources/css/myPageMain.css"/>
</head>
<body>
	<%@ include file="../top/top.jsp" %>
	<%@ include file="mypageNavi.jsp" %>
	
	<c:if test="${loginInfo == null}">
		<script>
			alert("로그인이 종료되어 메인페이지로 이동합니다.");
			location.href = "http://localhost:8787/vgan/welcome";
		</script>
	</c:if>
	
	<div class="mypageConWrapper">
		<div class="mypageTitle">나의 리뷰보기</div>
		<div class="likeMenuDiv">안녕?</div>
		<div class="likeMenuDiv">안녕?</div>
	</div>
	
	
	<script src="/vgan/resources/js/top.js"></script>
</body>
</html>