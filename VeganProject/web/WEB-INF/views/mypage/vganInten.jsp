<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/vgan/resources/css/top.css" />
<link rel="stylesheet" href="/vgan/resources/css/myPageMain.css" />
<link rel="stylesheet" href="/vgan/resources/css/vganInten.css"/>
</head>
<body>
	<%@ include file="mypageNavi.jsp"%>
	<%@ include file="../top/top.jsp"%>
	<div class="mypageConWrapper">
		<div class="mypageTitle">채식지향 설정</div>
		<div id="name">${loginInfo.nickname}</div><div>님의 채식 지향 정보</div>
		<c:if test="${loginInfo.vLId != null}">
			<div id="vL">${loginInfo.vLId}</div>
			<div>새롭게 설정하고 싶다면 아래 버튼을 눌러주세요!</div>
		</c:if>
		<c:if test="${loginInfo.vLId == null}">
			<div id="vL">아직 설정하지 않았습니다.</div>
		</c:if>
		<button id="setVegan" onclick="setVegan();">설정하러 가기</button>
		<form style="display: none;">
			<select name="vLevel">
				<option value="FXT">플렉시테리언</option>
				<option value="POP">폴로페스코</option>
				<option value="PSC">페스코</option>
				<option value="POL">폴로</option>
				<option value="LOV">락토오보</option>
				<option value="LTO">락토</option>
				<option value="OVO">오보</option>
				<option value="VGN">비건</option>
				<option value="FTN">프루테리언</option>
			</select>
			<button>설정하기</button>
		</form>
		<button style="border: 1px solid gray; background: white; font-size: 17px;" onclick="vganExplain();">채식 지향에 대해 알아보기</button>
		<table id="vganTable" style="display: none">
			<tbody>
				<tr>
					<th></th>
					<th>육류</th>
					<th>가금류</th>
					<th>어패류</th>
					<th>난류</th>
					<th>유지류</th>
					<th>균류</th>
					<th>해조류</th>
					<th>야채류</th>
					<th>열매류</th>
				</tr>
				<tr>
					<th>플렉시테리언</th>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
				</tr>
				<tr>
					<th>폴로페스코</th>
					<td>X</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
				</tr>
				<tr>
					<th>페스코</th>
					<td>X</td>
					<td>X</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
				</tr>
				<tr>
					<th>폴로</th>
					<td>X</td>
					<td>O</td>
					<td>X</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
				</tr>
				<tr>
					<th>락토오보</th>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
				</tr>
				<tr>
					<th>락토</th>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
				</tr>
				<tr>
					<th>오보</th>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>O</td>
					<td>X</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
				</tr>
				<tr>
					<th>비건</th>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
					<td>O</td>
				</tr>
				<tr>
					<th>프루테리언</th>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>X</td>
					<td>O</td>
				</tr>
			</tbody>
	
		</table>
	</div>
	<script src="/vgan/resources/js/top.js"></script>
	<script>
		function vganExplain() {
			var table = document.querySelector('#vganTable');
			
			if(table.style.display != "table") {
				table.style.display = "table";
			} else {
				table.style.display = "none";
			}
		}
		
		function setVegan() {
			var form = document.querySelector('form');
			
			if(form.style.display != "block") {
				form.style.display = "block";
			} else {
				form.style.display = "none";
			}
		}
	</script>
</body>
</html>