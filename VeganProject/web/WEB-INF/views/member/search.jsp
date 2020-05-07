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
</style>
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
				<div style="text-align: center;">이름과 아이디로 비밀번호를 변경할 수 있습니다.</div>
				<form action="/vgan/searchId" method="post">
					<div class="inputTitle">이름</div>
					<input class="searchInput" text="text" name="nickName">
					<div class="inputTitle">아이디</div>
					<input class="searchInput" type="text" name="userEmail"><br>
					<button class="searchBtn">확인</button>
				</form>
			</c:if>
			<c:if test="${keyword == 0 }">
				<div style="text-align: center;">이름과 핸드폰번호로 계정을 찾을 수 있습니다.</div>
				<form action="/vgan/searchId" method="post">
					<div class="inputTitle">이름</div>
					<input class="searchInput" text="text" name="nickName">
					<div class="inputTitle">핸드폰번호</div>
					<input class="searchInput" type="text" name="userPhone"><br>
					<button class="searchBtn">확인</button>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>