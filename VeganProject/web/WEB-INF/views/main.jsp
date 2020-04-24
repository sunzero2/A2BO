<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
<title>Insert title here</title>
<link rel="stylesheet" href="/vgan/resources/css/top.css"/>
<link rel="stylesheet" href="/vgan/resources/css/main.css"/>
<link rel="stylesheet" href="/vgan/resources/css/login.css"/>
<link rel="stylesheet" href="/vgan/resources/css/iframe.css"/>
</head>
<body>
	<%@ include file="top/top.jsp"%>
	
	<div class="content">

		<div class="mainImage">
			<img src="///">
		</div>

		<div class="ingChoice">
			<div class="fxt">1<img src=""></div>
			<div class="pop">2<img src=""></div>
			<div class="psc">3<img src=""></div>
			<div class="pol">4<img src=""></div>
			<div class="lov">5<img src=""></div>
			<div class="lto">6<img src=""></div>
			<div class="ovo">7<img src=""></div>
			<div class="vgn">8<img src=""></div>	
			<div class="ftn">9<img src=""></div>
		</div>
		
		<button class=""><i class="fas fa-search" style="color:black"></i>확인하기</button>



	</div>
	
	<!--
		아래는 로그인이랑 회원가입 단에서 필요한 겁니다. 절대로 지우지 마세요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! - 혜영
	-->
	<div class="screenDiv"></div>
	<div class="innerDiv">
		<div class="iframeWrapper">
			<button class="closeBtn">X</button>
			<iframe class="iframe" src="http://localhost:8787/vgan/member/goin"></iframe>
		</div>
	</div>
	
	<!-- 배너 스크립트입니다. -혜영 -->
	<script src="/vgan/resources/js/top.js"></script>
</body>
</html>