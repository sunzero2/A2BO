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
<body>
	<%@ include file="../mypage/mypageNavi.jsp" %>
	<%@ include file="../top/top.jsp" %>
	
	<div class="mypageConWrapper"> 
		<div class="mainCalHeader">
			<span>Calendar</span>
			<span>이번 달 채식 횟수를 체크해보세요!</span>
			<div class="">
				<span>2020</span>
				<a href="">저번 달</a>
				<span>4</span>
				<a href="">다음 달</a>
			</div>
		</div>
		<div class="mainCalContent">
			<table class="mainCalDayHead">
				<tbody>
					<tr>
						<th>일</th>
						<th>월</th>
						<th>화</th>
						<th>수</th>
						<th>목</th>
						<th>금</th>
						<th>토</th>
					</tr>
				</tbody>
			</table>
			<div class="mainCalDayCon">
				<!-- mainCalMonthRow 부분은 나중에 반복문 돌려서 출력할 것. -->
				<div class="mainCalMonthRow">
					<table class="mainCalDayDiv">
						<tbody>
							<tr>
								<td class="mainCalTd"></td>
								<td class="mainCalTd mainCalGrid"></td>
								<td class="mainCalTd mainCalGrid"></td>
								<td class="mainCalTd mainCalGrid"></td>
								<td class="mainCalTd mainCalGrid"></td>
								<td class="mainCalTd mainCalGrid"></td>
								<td class="mainCalTd mainCalGrid"></td>
							</tr>
						</tbody>
					</table>
					<table class="mainCalDayText">
						<tbody style="vertical-align: baseline;">
							<tr>
								<td class="maincalTd">1</td>
								<td class="maincalTd">2</td>
								<td class="maincalTd">3</td>
								<td class="maincalTd">4</td>
								<td class="maincalTd">5</td>
								<td class="maincalTd">6</td>
								<td class="maincalTd">7</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
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
</body>
</html>