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
<style>
	table {
		border: 1px solid #BDBDBD;
		text-align: center;
		width: 1100px;
		height: 500px;
		border-spacing: 0px;
	}
</style>
</head>
<body onload="build();">
	<%@ include file="../mypage/mypageNavi.jsp" %>
	<%@ include file="../top/top.jsp" %>
	
	<div class="mypageConWrapper"> 
		<div class="mainCalHeader">
			<div>
				<div class="mypageTitle">Calendar</div>
				<a style="float: right; font-size: 15px; margin-right: 10px;">메모장</a>
			</div>
			<span>이번 달 채식 횟수를 체크해보세요!</span>
		</div>
		<div class="mainCalContent">
			<table align="center" id="calendar">
				<tr>
					<td class="tdTitle"><font color="#B3B6B3"><label onclick="beforeMonth()" id="before"></label></font></td>
					<td class="tdTitle" colspan="5" align="center" id="yearmonth"></td>
					<td class="tdTitle"><font color="#B3B6B3"><label onclick="nextMonth()" id="next"></label></font></td>
				</tr>
				<tr>
					<td class="tdTitle" align="center"><font color="#FF9090">일</font></td>
					<td class="tdTitle" align="center">월</td>
					<td class="tdTitle" align="center">화</td>
					<td class="tdTitle" align="center">수</td>
					<td class="tdTitle" align="center">목</td>
					<td class="tdTitle" align="center">금</td>
					<td class="tdTitle" align="center"><font color=#7ED5E4>토</font></td>
				</tr>
			</table>
		</div>
		<div class="mainCalTotal">
			<span class="mainCalTotalSum">30</span>
			<span class="mainCalTotalTitle">이번 달 나의 채식 횟수 :</span>
		</div>
	</div>
	
	<div class="screenDiv"></div>
	<div class="innerDiv">
		<div class="iframeWrapper">
			<button class="closeBtn">X</button>
			<iframe class="iframe" src="http://localhost:8787/vgan/calendar/calSub"></iframe>
		</div>
	</div>
	<script src="/vgan/resources/js/iframe.js"></script>
	<script src="/vgan/resources/js/calendar.js"></script>
</body>
</html>