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
	<c:if test="${alertMsg != null}">
		<script>
			alert("${alertMsg}");
		</script>
	</c:if>
	
	<div class="mypageConWrapper"> 
		<span>개인정보수정</span>
		<table>
			<tr>
				<th class="privacyTh" scope="row">닉네임</th>
				<td class="privacyTd">
					<div>${loginInfo.nickname}</div>
					<button class="privacyBtn" id="nickname">수정</button>
					<div class="changeNickname">
						<form action="changeMember" method="post">
							<input name="nickname" type="text" placeholder="변경할 닉네임">
							<button>수정</button>
						</form>
					</div>
				</td>
			</tr>
			<tr>
				<th class="privacyTh" scope="row">계정</th>
				<td class="privacyTd">
					<div>
						<span>${loginInfo.userEmail}</span>
					</div>
				</td>
			</tr>
			<tr>
				<th class="privacyTh" scope="row">비밀번호</th>
				<td class="privacyTd">
					<div>현재 비밀번호를 입력하세요.</div>
					<input id="pwdCheck" type="password"><br>
					<button class="privacyBtn" id="password">수정</button>
					<div class="changePw">
						<form action="changeMember" method="post" onsubmit="return validate();">
							<input name="password" id="userPwd" type="password" placeholder="새 비밀번호"><br>
							<span id="pwdSpan" style="display: none; font-size: 13px;"></span>
							<input type="password" id="userPwdCheck" placeholder="새 비밀번호 확인"><br>
							<span id="checkSpan" style="display: none; font-size: 13px;"></span>
							<button>수정</button>
						</form>
					</div>
				</td>
			</tr>
			<tr>
				<th class="privacyTh" scope="row">핸드폰번호</th>
				<td class="privacyTd">
					<c:if test="${loginInfo.cell == null}">
						<div>등록하신 핸드폰 번호가 없습니다.</div>
					</c:if>
					<c:if test="${loginInfo.cell != null}">
						<div>${loginInfo.cell}</div>					
					</c:if>
					<button class="privacyBtn" id="cell">수정</button>
					<div class="changeCell">					
						<form action="changeMember" method="post">
							<input name="cell" type="text" placeholder="변경할 핸드폰 번호">
							<button>수정</button>
						</form>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<script src="/vgan/resources/js/top.js"></script>
	<script src="/vgan/resources/js/privacy.js"></script>
</body>
</html>