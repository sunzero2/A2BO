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
	<form action="addevent">
		<div class="subCalTitle"></div>
		<div>
			<textarea class="subCalMenuContent" name="content" placeholder="오늘의 일기를 작성해보세요!(최대 300자까지 입력가능)" maxlength=300>
			</textarea><br>
		</div>
		<div class="subCalIconDiv">
			<div class="subCalSelectDiv">
				<img id="FXT" src="/vgan/resources/image/FXT.png">
				<input name="icon" class="subCalIconCheck" type="radio" value="FXT">
			</div>
			
			<div class="subCalSelectDiv col2">
				<img id="POP" src="/vgan/resources/image/POP.png">
				<input name="icon" class="subCalIconCheck" type="radio" value="POP">
			</div>
			
			<div class="subCalSelectDiv col3">
				<img id="PSC" src="/vgan/resources/image/PSC.png">
				<input name="icon" class="subCalIconCheck" type="radio" value="PSC">
			</div>
			
			<div class="subCalSelectDiv row2">
				<img id="POL" src="/vgan/resources/image/POL.png">
				<input name="icon" class="subCalIconCheck" type="radio" value="POL">
			</div>	
			<div class="subCalSelectDiv col2 row2">
				<img id="LOV" src="/vgan/resources/image/LOV.png">
				<input name="icon" class="subCalIconCheck" type="radio" value="LOV">
			</div>
			<div class="subCalSelectDiv col3 row2">
				<img id="LTO" src="/vgan/resources/image/LTO.png">
				<input name="icon" class="subCalIconCheck" type="radio" value="LTO">
			</div>
			<div class="subCalSelectDiv row3">
				<img id="OVO" src="/vgan/resources/image/OVO.png">
				<input name="icon" class="subCalIconCheck" type="radio" value="OVO">
			</div>
			<div class="subCalSelectDiv col2 row3">
				<img id="VGN" src="/vgan/resources/image/VGN.png">
				<input name="icon" class="subCalIconCheck" type="radio" value="VGN">
			</div>
			<div class="subCalSelectDiv col3 row3">
				<img id="FTN" src="/vgan/resources/image/FTN.png">
				<input name="icon" class="subCalIconCheck" type="radio" value="FTN">
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
		<button name="btn" value="save" class="subCalBtn save">저장</button>
		<button name="btn" value="remove" class="subCalBtn remove">삭제</button>
		<button name="btn" value="change" class="subCalBtn change">수정</button>
		<input name="date" type="hidden" value="">
	</form>
	<span class="subCalMsg">오늘의 채식을 기록해보세요!</span>
</div>
<script src="/vgan/resources/js/iframe.js"></script>
<script>
	var img = document.querySelectorAll('img');
	document.querySelectorAll('.subCalIconCheck').forEach(function(el) {
		el.addEventListener('click', function(v) {
			if(v.target.checked) {
				for(i = 0; i < img.length; i++) {
					if(img[i].id == v.target.value) {
						img[i].parentNode.style.background = "#ffbd40";
					} else {
						img[i].parentNode.style.background = "white";
					}
				}
			}
		})
	})
</script>
</body>
</html>