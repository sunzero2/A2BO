<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.content {
		width: 700px;
		margin-left: 49px;
		margin-top: 20%;
	}
	
	.conTitle {
		text-align: center;
		font-size: 40px;
		font-weight: bold;
	}
	
	.conBody {
		margin-top: 34px;
	}
	
	form {
		margin-left: 27%;
	}
	
	.inputTitle {
		margin-top: 15px;
	}
	
	.searchInput {
		width: 310px;
		height: 30px;
	}
	
	.searchBtn {
		border: 1px solid;
		background: none;
		margin-left: 25%;
		margin-top: 10px;
		font-size: 16px;
		width: 60px;
		height: 34px;
	}
	
	.resultWrapper {
		border: 1px solid;
		margin-top: 38px;
		height: 150px;
	}
</style>
</head>
<body>
	<c:if test="${complatedChangePw != null}">
		<c:if test="${complatedChangePw}">
			<script>
				alert("비밀번호 변경이 완료되었습니다. 다시 로그인해주세요.");
				window.close();
			</script>
		</c:if>
		<c:if test="${!complatedChangePw}">
			<script>
				alert("비밀번호 변경에 실패하였습니다. 재시도 해주세요.");
			</script>
		</c:if>
	</c:if>

	<div class="content">
		<div class="conTitle">
			<c:if test="${keyword > 0}">
				<div>패스워드 찾기</div>
			</c:if>
			<c:if test="${keyword == 0}">
				<div>계정 찾기</div>
			</c:if>
		</div>
		<div class="conBody">
			<!-- 아이디, 비밀번호 찾기 눌렀을 때 처음 나오는 곳 -->
			<!-- 여기는 회원의 비밀번호 찾기 -->
			<c:if test="${keyword > 0 }">
				<div style="text-align: center;">이름과 아이디로 비밀번호를 변경할 수 있습니다.</div>
				<form action="/vgan/member/searchPw" method="post">
					<div class="inputTitle">이름</div>
					<input class="searchInput" text="text" name="nickName">
					<div class="inputTitle">아이디</div>
					<input class="searchInput" type="text" name="userEmail"><br>
					<button class="searchBtn">확인</button>
				</form>
			</c:if>
			<!-- 여기는 회원의 아이디 찾기 -->
			<c:if test="${keyword == 0 }">
				<div style="text-align: center;">이름과 핸드폰번호로 계정을 찾을 수 있습니다.</div>
				<form action="/vgan/member/searchId" method="post">
					<div class="inputTitle">이름</div>
					<input class="searchInput" text="text" name="nickName">
					<div class="inputTitle">핸드폰번호</div>
					<input class="searchInput" type="text" name="userPhone"><br>
					<button class="searchBtn">확인</button>
				</form>
			</c:if>
			
			<!-- 아이디, 비밀번호 찾기 눌러서 값 입력하고 나서 나오는 곳 -->
			<!-- 여기는 회원의 아이디 알려주는 곳 -->
			<c:if test="${userEmail != null}">
				<div>
					<div style="font-size: 30px; font-weight: bold;">계정 찾기</div>
					<div style="font-size: 14px; margin-top: 6px;">회원님의 정보와 일치하는 계정을 보여드립니다.</div>
					<!-- 회원이 정보를 제대로 입력했을 때 나오는 곳 -->
					<c:if test="${userEmail.length() > 0}">
						<div class="resultWrapper">
							<div>${userEmail}</div>
						</div>
						<button onclick="loginGoin();">로그인하기</button>
					</c:if>
					<!-- 회원이 정보를 제대로 입력하지 않았을 때 나오는 곳 -->
					<c:if test="${userEmail.length() == 0}">
						<div class="resultWrapper">
							<div>계정 찾기에 실패하였습니다. 입력하신 정보를 확인해주세요.</div>
						</div>
						<button onclick="again('id');">다시 시도하기</button>
					</c:if>
				</div>
			</c:if>
			<!-- 여기는 회원의 비밀번호 알려주는 곳 -->
			<c:if test="${userPw != null}">
				<div>
					<div style="font-size: 30px; font-weight: bold;">비밀번호 찾기</div>
					<!-- 회원이 정보를 제대로 입력했을 때 나오는 곳 -->
					<c:if test="${userPw > 0}">
						<div style="font-size: 14px; margin-top: 6px;">변경하실 비밀번호를 입력해주세요.</div>
						<div>비밀번호는 8~15자로 입력. 영어 소문자, 숫자, 특수문자를 1개 이상 입력해야 합니다.</div>
						<form action="/vgan/member/changePw" onsubmit="return validate();">
							<input class="" name="userEmail" type="hidden" value="${findId}">
							<input class="" name="userPw" id="userPwd" type="password" placeholder="8~15글자의 영문자로 작성하세요.(숫자, 특수문자 1개 이상 포함)"><br>
							<span id="pwdSpan" style="display: none; font-size: 13px;  margin-left: 50px;"></span>
							<input class="" id="pwdCheck" type="password" placeholder="비밀번호 재입력"><br>
							<span id="checkSpan" style="display: none; font-size: 13px;  margin-left: 50px;"></span>
							<button>변경</button>
						</form>
						<div>허용가능한 특수문자 : $, @, !, %, *, #, ?, &</div>
					</c:if>
					<!-- 회원이 정보를 제대로 입력하지 않았을 때 나오는 곳 -->
					<c:if test="${userPw == 0}">
						<div>비밀번호 찾기에 실패하였습니다. 입력하신 정보를 확인해주세요.</div>
						<button onclick="again('pw');">다시 시도하기</button>
					</c:if>
				</div>
			</c:if>
		</div>
	</div>
	
	<script>
	var isSuccess = false;
	var span = document.querySelector('#pwdSpan');
	var check = document.querySelector('#checkSpan');
	
	function validate() {
		if(!isSuccess) {
			alert("비밀번호를 확인하세요.");
		}
		
		return isSuccess;
	}
	
	document.querySelector('#userPwd').onkeydown = function(v) {
		var pw = document.querySelector('#userPwd');
		var regExpPw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,15}$/;
		var testStr = pw.value + v.key;
		
		function chk(re, e, msg) {
			if(re.test(e)) {
				span.style.display = 'none';
				isSuccess = true;
			} else {
				span.style.display = 'block';
				span.style.color = 'red';
				span.textContent = msg;
				isSuccess = false;
			}
		}

		if(chk(regExpPw, testStr, '비밀번호를 확인하세요.')) {
			isSuccess = false;
		}
	}


	document.querySelector('#pwdCheck').onkeydown = function(v) {
		var pw = document.querySelector('#userPwd');
		var ch = document.querySelector('#pwdCheck');
		var testStr = ch.value + v.key;
		
		if(testStr == pw.value) {
			check.style.display = 'block';
			check.style.color = 'blue';
			check.textContent = "비밀번호가 일치합니다.";
			isSuccess = true;
		} else {
			check.style.display = 'block';
			check.style.color = 'red';
			check.textContent = "비밀번호가 일치하지 않습니다.";
			isSuccess = false;
		}
	}
	
	function loginGoin() {
		location.href = "http://localhost:8787/vgan/member/goin";
	}
	
	function again(keyword) {
		location.href = "http://localhost:8787/vgan/member/searchmem?keyword=" + keyword;
	}
	</script>
</body>
</html>