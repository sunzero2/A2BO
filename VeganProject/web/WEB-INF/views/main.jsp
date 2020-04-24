<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
<title>Insert title here</title>
<link rel="stylesheet" href="/vgan/resources/css/top.css"/>
<link rel="stylesheet" href="/vgan/resources/css/main.css"/>
<link rel="stylesheet" href="/vgan/resources/css/login.css"/>
<link rel="stylesheet" href="/vgan/resources/css/iframe.css"/>
<style>
	.topBanner {
		margin-top: 0px;
	}
</style>
</head>
<body>
	<%@ include file="top/top.jsp"%>
	
	<div class="content">

		<div class="mainImage">
			image hi
		</div>

		<div class="ingBox">
			<div class="choice1line">
			<!--img 테스트 할 때는 http://placehold.it/가로x세로 넣어서 해주세요 -->
				<div class="fxt">1<img src="http://placehold.it/100x100"></div>
				<div class="pop">2<img src=""></div>
				<div class="psc">3<img src=""></div>
			</div>
			
			<div class="choice2line">
				<div class="pol">4<img src=""></div>
				<div class="lov">5<img src=""></div>
				<div class="lto">6<img src=""></div>
			</div>
			
			<div class="choice3line">
				<div class="ovo">7<img src=""></div>
				<div class="vgn">8<img src=""></div>	
				<div class="ftn">9<img src=""></div>
			</div>
			
		</div>
		
		<button class="">단계 확인하기</button>
		
		<div class="myLevel"></div><!-- 확인하기 눌렀을 떄 나의 단계가 나오게 하는것 ajax로 구현 -찬경 -->

		<div class="menuList">
				<div class="menuCard">
					<div class="menuImage"><img src=""></div>
					<div class="menuInfo">
						<div class="menuName">메뉴 이름 : </div>
						<div class="menuPoint">별점 : </div>	
						<div class="menuAd">주소 : </div>	
					</div>
				</div>
		</div>



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
	<script src="/vgan/resources/js/iframe.js"></script>
</body>
</html>