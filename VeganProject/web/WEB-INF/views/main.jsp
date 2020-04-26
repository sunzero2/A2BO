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
		<h1>나의 단계확인하기</h1>
		<h3>좋아하는 재료를 선택하세요</h3>
		<br>
		<div class="ingBox">
			<div class="choiceline1">
				<div id="Meat" class="ingItem1"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="meat" name="ing">육류</div>
				
				<div id="Poultry" class="ingItem2"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="poultry" name="ing">가금류</div>
				
				<div id="Seafood" class="ingItem3"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="seafood" name="ing">어패류</div>
				
				<div id="Fishes" class="ingItem4"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="fishes" name="ing">어류</div>
				
				<div id="Mollusks" class="ingItem5"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="mollusks" name="ing">연체류</div>
				
			</div>
			
			<div class="choiceline2">
				<div id="Crustacean" class="ingItem1"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="crustacean" name="ing">갑각류</div>
				
				<div id="ShellFishes" class="ingItem2"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="shellFishes" name="ing">조개류</div>
				
				<div id="Eggs" class="ingItem3"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="eggs" name="ing">난류</div>
				
				<div id="Oil" class="ingItem4"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="oil" name="ing">유지류</div>
				
				<div id="Fungus" class="ingItem5"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="fungus" name="ing">균류</div>
				
			</div>
			
			<div class="choiceline3">
				<div id="Seaweed" class="ingItem1"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="seaweed" name="ing">해조류</div>
				
				<div id="Vegetable" class="ingItem2"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="vegetable" name="ing">야채류</div>
				
				<div id="Fruits" class="ingItem3"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="fruits" name="ing">열매류</div>
				
				<div id="Grains" class="ingItem4"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="grains" name="ing">곡류</div>
				
				<div id="Dairy" class="ingItem5"><div class="ingImage"><img src="http://placehold.it/200x150"></div>
					<input type="radio" class="menuRadio" value="dairy" name="ing">유제품</div>
				
			</div>
			
		</div>
		
		<button class="level" type="submit" onclick="menuList()">단계 확인하기</button>
		
		<div class="myLevel">나의 비건 단계 나오는 디브</div><!-- 확인하기 눌렀을 떄 나의 단계가 나오게 하는것 ajax로 구현 -찬경 -->

		<div class="menuList">
				<div class="menuCard"><!-- 메뉴 카드 눌렀을때 페이지 내에서 뜨는것 아이프레임으로 설정 -->
					
				</div>
				<br><br><br>
				<div class="menuInfoBox">
				
				</div>
		</div>



	</div>
	<script src="/vgan/resources/js/main.js"></script><!--나의 비건 단계 확인 눌렀을때 단계에 맞는 메뉴 추천 카드, 메뉴 상세보기  스크립트문   -찬경  -->
	
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