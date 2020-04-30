<%@page import="com.a2bo.calendar.model.vo.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	
	<!-- html -->
	<div class="mypageConWrapper"> 
		<div class="mainCalHeader">
			<div>
				<div class="mypageTitle">Calendar</div>
				<a href="/vgan/calendar/memoList" style="float: right; font-size: 15px; margin-right: 10px;">메모장</a>
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
	
	<!-- jstl -->
	<c:if test="${loginInfo == null}">
		<script>
			alert("로그인이 종료되어 메인페이지로 이동합니다.");
			location.href = "http://localhost:8787/vgan/welcome";
			//response.redirection
		</script>
	</c:if>
	
	<c:if test="${calList != null}">
		<%
			List list = (List)request.getAttribute("calList");
			List dayList = new ArrayList();
			List iconList = new ArrayList();
			for(int i = 0; i < list.size(); i++) {
				dayList.add(i, ((Calendar)list.get(i)).getcDate());
				iconList.add(i, ((Calendar)list.get(i)).getIcon());
			}
			pageContext.setAttribute("dayList", dayList);
			pageContext.setAttribute("iconList", iconList);
			pageContext.setAttribute("list", list);
		%>
	</c:if>
	
	<script>
		var dayList = ${dayList};
		
		function addIcon() {
			if(dayList != null) {
				document.querySelectorAll('.calendarTd').forEach(function(el) {
					for(var i = 0; i < dayList.length; i++) {
						if(dayList[i] == el.id) {
							$.ajax({
								url:
							})
							el.children[0].style.background = "url('/vgan/resources/image/money.jpg')";
							/* el.children[0].style.background = "url('/vgan/resources/image/" + icon + ".png')"; */
						}
					}
				})
			}
		}
		
		function addData(data) {
			for(var i = 0; i < dayList.length; i++) {
				console.dir(dayList[i]);
				console.dir(data.id);
				if(dayList[i] == data.id) {
					console.log("dddddd");
					//${list.get(i)};
					console.log(i);
					var content = "${calList.get(i).cCont}";
					var price = ${calList.get(i).cPrice};
					var menu = "${calList.get(i).cMenu}";
					
					console.log(content);
					console.log(price);
					console.log(menu);
				}
			}
		}
	</script>
	 
	 <!-- iframe -->
	<div class="screenDiv"></div>
	<div class="innerDiv">
		<div class="iframeWrapper">
			<button class="closeBtn">X</button>
			<iframe class="iframe" src="http://localhost:8787/vgan/calendar/calSub"></iframe>
		</div>
	</div>
	
	<!-- script -->
	<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
	<script src="/vgan/resources/js/calendar.js"></script>
	<script src="/vgan/resources/js/iframe.js"></script>
</body>
</html>