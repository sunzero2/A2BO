<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:8787/vgan/resources/css/top.css"/>
<link rel="stylesheet" href="http://localhost:8787/vgan/resources/css/myPageMain.css"/>
<link rel="stylesheet" href="http://localhost:8787/vgan/resources/css/privacy.css"/>
</head>
<body>
	<%@ include file="mypageNavi.jsp" %>
	<%@ include file="../top/top.jsp" %>
		
	<c:if test="${loginInfo == null}">
		<script>
			alert("로그인이 종료되어 메인페이지로 이동합니다.");
			location.href = "http://localhost:8787/vgan/welcome";
		</script>
	</c:if>
	
	<c:if test="${alertMsg != null}">
		<script>
			alert("${alertMsg}");
		</script>
	</c:if>
	
	<div class="mypageConWrapper">
		<div class="mypageHeader">
			<div class="mypageTitle">개인정보수정</div>
		</div>
		<table class="privacyTb">
			<tbody>
				<tr>
					<th class="privacyTh" scope="row">
						<div class="innerThDiv">닉네임</div>
					</th>
					<td class="privacyTd">
						<div class="privacyTdTitle">${loginInfo.nickname}</div>
						<button class="privacyBtn" id="nickname">수정</button>
						<div class="changeNickname">
							<form action="http://localhost:8787/vgan/mypage/changemember" method="post">
								<input class="privacyInput" name="nickname" type="text" placeholder="변경할 닉네임"><br>
								<button class="privacyBtn">수정</button>
							</form>
						</div>
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<th class="privacyTh" scope="row">
						<div class="innerThDiv" style="margin-top: 0px;">계정</div>
					</th>
					<td class="privacyTd">
						<div class="privacyTdTitle" style="position: relative;">${loginInfo.userEmail}</div>
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<th class="privacyTh" scope="row">
						<div class="innerThDiv">비밀번호</div>
					</th>
					<td class="privacyTd">
						<div class="privacyTdTitle">현재 비밀번호를 입력하세요.</div>
						<input class="privacyInput" id="pwdCheck" type="password"><br>
						<button class="privacyBtn" id="password">수정</button>
						<div class="changePw">
							<form action="http://localhost:8787/vgan/mypage/changemember" method="post" onsubmit="return validate();">
								<input class="privacyInput" name="password" id="userPwd" type="password" placeholder="새 비밀번호"><br>
								<span id="pwdSpan" style="display: none; font-size: 13px;"></span>
								<input class="privacyInput" type="password" id="userPwdCheck" placeholder="새 비밀번호 확인"><br>
								<span id="checkSpan" style="display: none; font-size: 13px;"></span>
								<button class="privacyBtn">수정</button>
							</form>
						</div>
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<th class="privacyTh" scope="row">
						<div class="innerThDiv">핸드폰번호</div>
					</th>
					<td class="privacyTd">
						<c:if test="${loginInfo.cell == null}">
							<div class="privacyTdTitle">등록하신 핸드폰 번호가 없습니다.</div>
						</c:if>
						<c:if test="${loginInfo.cell != null}">
							<div class="privacyTdTitle">${loginInfo.cell}</div>					
						</c:if>
						<button class="privacyBtn" id="cell">수정</button>
						<div class="changeCell">					
							<form action="http://localhost:8787/vgan/mypage/changemember" method="post">
								<input class="privacyInput" name="cell" type="text" placeholder="변경할 핸드폰 번호"><br>
								<button class="privacyBtn">수정</button>
							</form>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<input id="userPw" type="hidden" value="${loginInfo.pw}">
	<script src="http://localhost:8787/vgan/resources/js/top.js"></script>
	<script src="http://localhost:8787/vgan/resources/js/privacy.js"></script>
</body>
</html>