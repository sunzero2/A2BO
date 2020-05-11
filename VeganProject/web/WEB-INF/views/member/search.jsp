<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="http://192.168.10.20:8787/vgan/resources/css/styles.css" rel="stylesheet" />
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: 'Varela Round', sans-serif;
	background-image: url("http://192.168.10.20:8787/vgan/resources/image/after/mbgimgesmallV.jpg");
}

/* .modal-login {
	width: 800px;
	height: 300px;
} */

.modal-login .modal-content {
	width: 700px;
	height: 500px;
	padding: 80px 80px 80px 80px;
	border-radius: 25px;
	left:-15%;
	border: none;
	background-image: url("http://192.168.10.20:8787/vgan/resources/image/after/mbgimgesmallV.jpg");
}

.modal-login .modal-header {
	border-bottom: none;
	position: relative;
	justify-content: center;
}

.modal-login h4 {
	text-align: center;
	font-size: 25px;
	font-weight: bold;
	color: #a077ff;
	position:relative;
}
.modal-login h2 {
	text-align: center;
	font-size: 13px;
	color: #a077ff;
	position:relative;
	font-weight: bold;
	top:-30px;
}

.modal-login .form-group {
	margin-bottom: 20px;
}

.modal-login .form-control, .modal-login .btn {
	min-height: 40px;
	border-radius: 30px;
	font-size: 15px;
	transition: all 0.5s;
}

.modal-login .form-control {
	font-size: 13px;
}

.modal-login .form-control:focus {
	border-color: #a177ff;
}

.modal-login .hint-text {
	text-align: center;
	padding-top: 10px;
}

.modal-login .close {
	position: absolute;
	top: -50px;
	right: -20px;
	color: #8250f5;
	font-size: xxx-large;
}

.modal-login .btn {
	background: #a177ff;
	border: none;
	line-height: normal;
}

.modal-login .btn:hover, .modal-login .btn:focus {
	background: #8753ff;
}

.trigger-btn {
	display: inline-block;
	margin: 100px auto;
}

.or-seperator {
	margin: 25px 0 0px;
	text-align: center;
	border-top: 2.3px solid #fff;
}

.or-seperator b {
	padding: 0 10px;
	width: 40px;
	height: 40px;
	font-size: 16px;
	text-align: center;
	line-height: 40px;
	background: #fff;
	display: inline-block;
	border-radius: 50%;
	position: relative;
	top: -22px;
	z-index: 1;
}

.form-control {
	background-color: #fdf8c2;
	border: 0.25px solid #ccc;
}

.modal-header-logo {
	position: relative;
	top: -100px;
	left: 25px;
	width: 260px;
}
.modal-body{
float:left;
margin: 20px 20px 20px 20px;
}
.findWrapper{
width: 800px;
	height: 300px;
}
</style>

<script>
	opener.location.href  = 'http://192.168.10.20:8787/vgan/member/searchmem';
	window.close();
</script>
<body>
	<img class="modal-header-logo" src="http://192.168.10.20:8787/vgan/resources/image/after/vganlogo-1w.png">
	<div class="modal-dialog modal-login">	
		<div class="modal-content">
			<div class="findWrapper">
				<div class="modal-body">
				<div class="modal-header">
					<h4 class="modal-title">Find My ID</h4>
				</div><br>
				<h2 class="modal-title">아이디 찾기</h2>
					<div class="form-group">
						<input type="text" class="form-control" id="idNickname" placeholder="Username" required="required">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="idPhone" placeholder="PhoneNumber" required="required">
					</div>
					<div class="form-group">
						<button onclick="searchId();" class="btn btn-primary btn-block btn-lg">Search</button>
					</div>
				</div>
				
				<div class="modal-body">
					<div class="modal-header">
						<h4 class="modal-title">Find My PW</h4>
					</div><br>
					<h2 class="modal-title">비밀번호 찾기</h2>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Username" id="pwNickName" required="required">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="UserEmail" id="pwEmail" required="required">
					</div>
					<div class="form-group">
						<button onclick="searchPw();" class="btn btn-primary btn-block btn-lg">Search</button>
					</div>
					<p class="hint-text small">
						<a id="backLogin" href="#"> LOGIN 페이지로 이동</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
	<script>
	document.querySelector('#backLogin').onclick = function() {
		window.open('http://192.168.10.20:8787/vgan/member/goin','login', 'width=800, height=1400, left=320px, top=150px');
		location.href = 'http://192.168.10.20:8787/vgan/welcome';
	}
	
	function searchId() {
		var nickName = document.querySelector('#idNickname').value;
		var phone = document.querySelector('#idPhone').value;
		$.ajax({
			url: "http://192.168.10.20:8787/vgan/member/searchid",
			data: {
				"nickName": nickName,
				"userPhone": phone
			},
			type: 'post',
			success: function(v) {
				if(v.length > 0) {
					alert("회원님의 계정은 " + v + "입니다.");
				} else {
					alert("입력하신 정보에 해당하는 계정이 없습니다.");
				}
			}
		})
		
	}
	
	function searchPw() {
		var userEmail = document.querySelector('#pwEmail').value;
		var nickName = document.querySelector('#pwNickName').value;
		$.ajax({
			url: "http://192.168.10.20:8787/vgan/member/searchpw",
			data: {
				"userEmail": userEmail,
				"nickName": nickName
			},
			type: 'post',
			success: function(v) {
				if(v > 0) {
					window.open('http://192.168.10.20:8787/vgan/member/pwchange?user=' + userEmail, 'pwChange', 'width: 800px, height: 400px');
				} else {
					alert("입력하신 정보와 일치하는 것이 없습니다. 다시 확인해주세요.");
				}
			}
		})	
	}
	</script>
</body>
</html>