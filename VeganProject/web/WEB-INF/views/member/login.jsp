<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/vgan/resources/css/login.css"/>
<title>Insert title here</title>
</head>
<body>
	<div class="loginWrapper">
		<div class="titleDiv" id="loginTitle">로그인</div>
		<form action="login" method="post">
			<input name="userEmail" class="loginInput" type="text" placeholder="아이디 입력"><br>
			<input name="userPwd" class="loginInput" type="password" placeholder="비밀번호 입력"><br>
			<button id="loginBt" type="submit">E N T E R</button>
		</form>
		<div class="searchMem">
			<a>ID찾기 /</a>
			<a>비밀번호찾기</a>
		</div>
		</div>
		
	<div class="joinWrapper">
		<div id="close" class="backPage"></div>
		<div class="titleDiv" id="joinTitle">회원가입</div>
		<form action="join" method="post" onsubmit="return validate();">
			<input class="joinInput input1" name="userName" type="text" placeholder="닉네임 입력"><br>
			<input class="joinEmail" name="userEmail" id="userEmail" type="text" placeholder="아이디 입력">
			<button class="emailCheck" type="button" onclick="emailCheck();">확인</button>
			<input class="joinInput" name="userPw" id="userPwd" type="password" placeholder="8~15글자의 영문자로 작성하세요.(숫자, 특수문자 1개 이상 포함)"><br>
			<span id="pwdSpan" style="display: none; font-size: 13px;  margin-left: 50px;"></span>
			<input class="joinInput" id="pwdCheck" type="password" placeholder="비밀번호 재입력"><br>
			<span id="checkSpan" style="display: none; font-size: 13px;  margin-left: 50px;"></span>
			<button id="joinBt">등록하기</button>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc=" crossorigin="anonymous">
	</script>
	<script src="/vgan/resources/js/login.js"></script>
</body>
</html>