<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/vgan/resources/css/calendar.css"/>
</head>
<body>
<c:if test="${success != null}">
	<script>
		window.open("http://localhost:8787/vgan/calendar/main", "_parent").parent.close();
	</script>
</c:if>

<div style="height: 650px; width: 750px;">
	<form action="addEvent">
		<div class="subCalTitle"></div>
		<div>
			<textarea class="subCalMenuContent" name="content" placeholder="오늘의 일기를 작성해보세요!(최대 300자까지 입력가능)" maxlength=300></textarea><br>
		</div>
		<div class="subCalIconDiv">
			<div class="subCalSelectDiv">
				<input name="inten" class="subCalIconCheck" type="checkbox" value="FXT">
				<span class="subCalIcon">플렉시테리언</span>
			</div>
			<div class="subCalSelectDiv col2" style="">
				<input name="inten" class="subCalIconCheck" type="checkbox" value="POP">
				<span class="subCalIcon">폴로페스코</span>
			</div>
			<div class="subCalSelectDiv col3">
				<input name="inten" class="subCalIconCheck" type="checkbox" value="PSC">
				<span class="subCalIcon">페스코</span>
			</div>
			<div class="subCalSelectDiv row2">
				<input name="inten" class="subCalIconCheck" type="checkbox" value="POL">
				<span class="subCalIcon">폴로</span>
			</div>
			<div class="subCalSelectDiv col2 row2">
				<input name="inten" class="subCalIconCheck" type="checkbox" value="LOV">
				<span class="subCalIcon">락토오보</span>
			</div>
			<div class="subCalSelectDiv col3 row2">
				<input name="inten" class="subCalIconCheck" type="checkbox" value="LTO">
				<span class="subCalIcon">락토</span>
			</div>
			<div class="subCalSelectDiv row3">
				<input name="inten" class="subCalIconCheck" type="checkbox" value="OVO">
				<span class="subCalIcon">오보</span>
			</div>
			<div class="subCalSelectDiv col2 row3">
				<input name="inten" class="subCalIconCheck" type="checkbox" value="VGN">
				<span class="subCalIcon">비건</span>
			</div>
			<div class="subCalSelectDiv col3 row3">
				<input name="inten" class="subCalIconCheck" type="checkbox" value="FTN">
				<span class="subCalIcon">프루테리언</span>
			</div>
		</div>
		<div class="subCalInputDiv subCalPrice">
			<div class="subCalInputTitle">가격</div>
			<input name="price" class="subCalInput" type="text">
		</div>
		<div class="subCalInputDiv subCalMenu">
			<div class="subCalInputTitle">음식</div>
			<input name="menu" class="subCalInput" type="text">
		</div>
		<button name="save" class="subCalBtn save">저장</button>
		<button name="remove" class="subCalBtn remove">삭제</button>
		<input name="date" type="hidden" value="">
	</form>
	<span class="subCalMsg">오늘의 채식을 기록해보세요!</span>
</div>
<script src="/vgan/resources/js/iframe.js"></script>
</body>
</html>