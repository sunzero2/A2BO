<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form action="member/login">
			<input class="loginInput" type="text" placeholder="EMAIL 입력"><br>
			<input class="loginInput" type="password" placeholder="비밀번호 입력"><br>
			<button id="loginBt" type="submit">E N T E R</button>
		</form>
		<div class="searchMem">
			<a>비밀번호찾기</a>
			<a>ID찾기/</a>
		</div>
		</div>
		
	<div class="joinWrapper">
		<div id="close" class="backPage"></div>
		<div class="titleDiv" id="joinTitle">회원가입</div>
		<form action="member/join" onsubmit="return validate();">
			<input name="userName" class="joinInput input1" type="text" placeholder="닉네임 입력"><br>
			<input name="userEmail" id="userEmail" class="joinEmail" type="text" placeholder="예) example@naver.com">
			<button type="button" class="emailCheck" onclick="emailCheck();">확인</button>
			<input name="userPw" id="userPwd" class="joinInput" type="password" placeholder="영어 소문자, 숫자 포함 8~15자로 입력"><br>
			<input class="joinInput" type="password" placeholder="비밀번호 재입력"><br>
			<button id="joinBt" type="submit">등록하기</button>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc=" crossorigin="anonymous">
	</script>
	<script src="/vgan/resources/js/login.js"></script>
</body>
</html>