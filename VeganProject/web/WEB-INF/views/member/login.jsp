<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/vgan/resources/css/styles.css" rel="stylesheet" />
<link rel="stylesheet" href="/vgan/resources/css/login.css"/>
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<div class="loginWrapper">
			<h1 class="section-heading loginTitle">LOGIN</h1>
			<form action="login" method="post">
				<input name="userEmail" class="memInput login" type="text" placeholder="아이디 입력"><br>
				<input name="userPwd" class="memInput login" type="password" placeholder="비밀번호 입력"><br>
				<button class="btn btn-primary btn-xl text-uppercase js-scroll-trigger loginBtn" id="loginBt" type="submit">E N T E R</button>
			</form>
			<div>
				<a class="nav-link searchMem" href="http://localhost:8787/vgan/member/searchmem?keyword=pw" style="margin-right: 77px;
				">비밀번호찾기</a>
				<a class="nav-link searchMem" href="http://localhost:8787/vgan/member/searchmem?keyword=id">ID찾기 </a>
			</div>
		</div>
		<div class="joinWrapper">
			<h1 class="section-heading loginTitle">JOIN</h1>
			<form action="join" method="post" onsubmit="return validate();">
				<input class="memInput join" name="userName" type="text" placeholder="닉네임 입력"><br>
				<input class="memInput join" style="width: 211px;" name="userEmail" id="userEmail" type="text" placeholder="아이디 입력">
				<button class="btn btn-primary btn-sm text-uppercase js-scroll-trigger" type="button" onclick="emailCheck();">확인</button><br>
				<input class="memInput join" name="userPw" id="userPwd" type="password" placeholder="8~15글자의 영문자로 작성하세요.(숫자, 특수문자 1개 이상 포함)"><br>
				<span id="pwdSpan" style="display: none; font-size: 13px;  margin-left: 50px;"></span>
				<input class="memInput join" id="pwdCheck" type="password" placeholder="비밀번호 재입력"><br>
				<span id="checkSpan" style="display: none; font-size: 13px;  margin-left: 50px;"></span>
				<button class="btn btn-primary btn-xl text-uppercase js-scroll-trigger loginBtn" id="joinBt">등록하기</button>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc=" crossorigin="anonymous">
	</script>
	<script src="/vgan/resources/js/login.js"></script>
</body>
</html>