<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="topBanner">
	<a class="topLogo" href="<%=request.getContextPath()%>/welcome">
		<div>
		<img src="">로고넣는곳
	</div></a>
	<div class="topLine">헤드라인 넣는곳</div>
	<div class="topLink aboutUs">
		<a>회사소개</a>
	</div>
	
	<c:if test="${loginInfo == null}">
		<div class="topLink join">
			<a>회원가입</a>
		</div>
		<div class="topLink login">
			<a>로그인</a>
		</div>
	</c:if>
	<c:if test="${loginInfo != null}">
		<div class="topLink logout">
			<a href="/vgan/member/logout">로그아웃</a>
		</div>
		<div class="topLink mypage">
			<a href="/vgan/mypage/main">마이페이지</a>
		</div>
	</c:if>
</div>