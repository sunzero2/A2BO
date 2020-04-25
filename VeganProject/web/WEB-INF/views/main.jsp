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
		<br>
		<div class="ingBox">
			<div class="choiceline1">
				<div id="Meat" class="ingItem1"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>육류</a></div>
				
				<div id="Poultry" class="ingItem2"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>가금류</a></div>
				
				<div id="Seafood" class="ingItem3"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>어패류</a></div>
				
				<div id="Fishes" class="ingItem4"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>어류</a></div>
				
				<div id="Mollusks" class="ingItem5"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>연체류</a></div>
				
			</div>
			
			<div class="choiceline2">
				<div id="Crustacean" class="ingItem1"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>갑각류</a></div>
				
				<div id="ShellFishes" class="ingItem2"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>조개류</a></div>
				
				<div id="Eggs" class="ingItem3"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>난류</a></div>
				
				<div id="Oil" class="ingItem4"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>유지류</a></div>
				
				<div id="Fungus" class="ingItem5"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>균류</a></div>
				
			</div>
			
			<div class="choiceline3">
				<div id="Seaweed" class="ingItem1"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>해조류</a></div>
				
				<div id="Vegetable" class="ingItem2"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>야채류</a></div>
				
				<div id="Fruits" class="ingItem3"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>열매류</a></div>
				
				<div id="Grains" class="ingItem4"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>곡류</a></div>
				
				<div id="Dairy" class="ingItem5"><div class="ingImage"><img src="http://placehold.it/200x150"></div><a class="ingName"><br>유제품</a></div>
				
			</div>
			
		</div>
		
		<button class="">단계 확인하기</button>
		
		<div class="myLevel">나의 비건 단계 나오는 디브</div><!-- 확인하기 눌렀을 떄 나의 단계가 나오게 하는것 ajax로 구현 -찬경 -->

		<div class="menuList">
				<div class="menuCard"><!-- 메뉴 카드 눌렀을때 페이지 내에서 뜨는것 아이프레임으로 설정 -->
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