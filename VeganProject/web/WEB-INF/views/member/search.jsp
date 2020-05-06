<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
			<c:if test="${keyword > 0 }">
				<form action="/vgan/searchId" method="post">
					<div>회원님의 아이디를 입력해주세요</div>
					<input type="text" name="userEmail">
					<button>확인</button>
				</form>
			</c:if>
			<c:if test="${keyword == 0 }">
				<form action="/vgan/searchPw" method="post">
					<div>이름과 핸드폰번호로 계정을 찾을 수 있습니다.</div>
					<div>이름</div>
					<input text="text" name="nickName">
					<div>핸드폰번호</div>
					<input text="text" name="userPhone">
					<button>확인</button>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>