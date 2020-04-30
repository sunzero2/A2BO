<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/vgan/resources/css/top.css"/>
<link rel="stylesheet" href="/vgan/resources/css/myPageMain.css"/>
<link rel="stylesheet" href="/vgan/resources/css/iframe.css"/>
<link rel="stylesheet" href="/vgan/resources/css/calendar.css"/>
</head>
<body onload="build();">
	<%@ include file="../mypage/mypageNavi.jsp" %>
	<%@ include file="../top/top.jsp" %>
		
	<c:if test="${loginInfo == null}">
		<script>
			alert("로그인이 종료되어 메인페이지로 이동합니다.");
			location.href = "http://localhost:8787/vgan/welcome";
			
			//response.redirection
		</script>
	</c:if>
	
	<div class="mypageConWrapper"> 
		<div class="mainCalHeader">
			<div>
				<div class="mypageTitle">Calendar</div>
				<a style="float: right; font-size: 15px; margin-right: 10px;">메모장</a>
			</div>
			<span>이번 달 채식 횟수를 체크해보세요!</span>
		</div>
		<div class="mainCalTable">
			<table class="mainCalTable" id="calendar">
				<tr>
					<td class="tdTitle">
						<label onclick="beforeMonth();" id="before"></label>
					</td>
					<td class="tdTitle" colspan="5" id="yearmonth"></td>
					<td class="tdTitle">
						<label onclick="nextMonth();" id="next"></label>
					</td>
				</tr>
				<tr>
					<td class="tdTitle" style="color: #FF9090;">일</td>
					<td class="tdTitle">월</td>
					<td class="tdTitle">화</td>
					<td class="tdTitle">수</td>
					<td class="tdTitle">목</td>
					<td class="tdTitle">금</td>
					<td class="tdTitle" style="color: #7ED5E4;">토</td>
				</tr>
			</table>
		</div>
		<div class="mainCalTotal">
			<span class="mainCalTotalSum">30</span>
			<span class="mainCalTotalTitle">이번 달 나의 채식 횟수 :</span>
		</div>
	</div>
	
	<c:if test="${calList != null}">
		<c:forEach items="${calList}" var="list">
			<div>머냐? : ${list.icon}</div>
		</c:forEach>
	</c:if>
	
	<div class="screenDiv"></div>
	<div class="innerDiv">
		<div class="iframeWrapper">
			<button class="closeBtn">X</button>
			<iframe class="iframe" src="http://localhost:8787/vgan/calendar/calSub"></iframe>
		</div>
	</div>
	 <script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
	<script src="/vgan/resources/js/calendar.js"></script>
	<script src="/vgan/resources/js/iframe.js"></script>
</body>
</html>