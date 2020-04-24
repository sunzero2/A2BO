<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/vgan/resources/css/calendar.css"/>
</head>
<body>
<div style="height: 650px; width: 750px;">
	<form>
		<div class="subCalTitle">
			<span>2020년 4월 24일</span>
		</div>
		<img class="subCalMenuImg" src="http://placehold.it/300x470">
		<div class="subCalIconDiv">
			<div class="subCalSelectDiv  ">
				<input class="subCalIconCheck" type="checkbox">
				<span class="subCalIcon">플렉시테리언</span>
			</div>
			<div class="subCalSelectDiv col2" style="">
				<input class="subCalIconCheck" type="checkbox">
				<span class="subCalIcon">폴로페스코</span>
			</div>
			<div class="subCalSelectDiv col3">
				<input class="subCalIconCheck" type="checkbox">
				<span class="subCalIcon">페스코</span>
			</div>
			<div class="subCalSelectDiv row2">
				<input class="subCalIconCheck" type="checkbox">
				<span class="subCalIcon">폴로</span>
			</div>
			<div class="subCalSelectDiv col2 row2">
				<input class="subCalIconCheck" type="checkbox">
				<span class="subCalIcon">락토오보</span>
			</div>
			<div class="subCalSelectDiv col3 row2">
				<input class="subCalIconCheck" type="checkbox">
				<span class="subCalIcon">락토</span>
			</div>
			<div class="subCalSelectDiv row3">
				<input class="subCalIconCheck" type="checkbox">
				<span class="subCalIcon">오보</span>
			</div>
			<div class="subCalSelectDiv col2 row3">
				<input class="subCalIconCheck" type="checkbox">
				<span class="subCalIcon">비건</span>
			</div>
			<div class="subCalSelectDiv col3 row3">
				<input class="subCalIconCheck" type="checkbox">
				<span class="subCalIcon">프루테리언</span>
			</div>
		</div>
		<div class="subCalInputDiv subCalPrice">
			<div class="subCalInputTitle">가격</div>
			<input class="subCalInput" type="text">
		</div>
		<div class="subCalInputDiv subCalMenu">
			<div class="subCalInputTitle">음식</div>
			<input class="subCalInput" type="text">
		</div>
		<button class="subCalBtn save">저장</button>
		<button class="subCalBtn remove">삭제</button>
	</form>
	<span class="subCalMsg">오늘의 채식을 기록해보세요!</span>
	
	<script>
		document.querySelectorAll('.subCalIconCheck').forEach(function(el) {
			el.addEventListener('click', function(v) {
				console.dir(v);
			})
		})
	</script>
</div>
</body>
</html>