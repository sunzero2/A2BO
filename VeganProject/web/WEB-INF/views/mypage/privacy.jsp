<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/vgan/resources/css/top.css"/>
<link rel="stylesheet" href="/vgan/resources/css/myPageMain.css"/>
<link rel="stylesheet" href="/vgan/resources/css/privacy.css"/>
</head>
<body>
	<%@ include file="mypageNavi.jsp" %>
	<%@ include file="../top/top.jsp" %>
	
	<div class="mypageConWrapper"> 
		<span>개인정보수정</span>
		<table>
			<tr>
				<th class="privacyTh" scope="row">닉네임</th>
				<td class="privacyTd">
					<div>회원의 닉네임</div>
					<button>수정</button>
					<form action="" method="post">
						<input type="text" placeholder="변경할 닉네임">
						<button>수정</button>
					</form>
				</td>
			</tr>
			<tr>
				<th class="privacyTh" scope="row">이메일</th>
				<td class="privacyTd">
					<div>이메일머시기웅앵웅</div>
					<span>이메일은 수정하실 수 없습니다.</span>
				</td>
			</tr>
			<tr>
				<th class="privacyTh" scope="row">비밀번호</th>
				<td class="privacyTd">
					<div>현재 비밀번호를 입력하세요.</div>
					<input type="password">
					<button>수정</button>
					<form action="" method="post">
						<input type="password" placeholder="새 비밀번호"><br>
						<input type="password" placeholder="새 비밀번호 확인">
						<button>수정</button>
					</form>
				</td>
			</tr>
			<tr>
				<th class="privacyTh" scope="row">핸드폰번호</th>
				<td class="privacyTd">
					<div>0100000000</div>
					<button>수정</button>
					<form action="" method="post">
						<input type="text" placeholder="변경할 핸드폰 번호">
						<button>수정</button>
					</form>
				</td>
			</tr>
		</table>
	</div>
	<script src="/vgan/resources/js/top.js"></script>
</body>
</html>