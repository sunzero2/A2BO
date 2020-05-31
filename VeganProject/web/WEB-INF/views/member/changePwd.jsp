<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
body {
	font-family: 'Varela Round', sans-serif;
	background-image: url("http://localhost:8787/vgan/resources/image/after/mbgimge2.jpg");
}

.modal-login {
	width: 500px;
	height: 400px;
}

.modal-login .modal-content {
	padding: 150px 80px 50px 80px;
	border-radius: 25px;
	border: none;
	background-image: url("http://localhost:8787/vgan/resources/image/after/mbgimgesmallV.jpg");
}

.modal-login .modal-header {
	border-bottom: none;
	position: relative;
	justify-content: center;
}

.modal-login h4 {
	text-align: center;
	font-size: 26px;
	font-weight: bold;
	color:#a077ff;
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

.modal-header-logo{
	position: absolute;
	margin-left: 24px;
	margin-top: -75px;
	width:260px;
}
p{
	font-size:13px;
	color:#a077ff;
	text-align:center;
	margin-bottom:-10px;
}

.modal-body-pw{
    position: relative;
    padding: 0px 15px 15px 15px;
}
</style>
</head>
<body>
<div class="modal-dialog modal-login">
	<div class="modal-content">
		<div class="modal-header">
			<img class="modal-header-logo" src="/vgan/resources/image/after/vganlogo-1w.png">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title">비밀번호 재입력</h4>
				<p>변경하실 비밀번호를 입력해주세요 </p>
		</div>
		<div class="modal-body-pw">
			<div class="form-group">
				<input type="password" class="form-control" id="password" placeholder="Password" required="required">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" id="pwdcheck"placeholder="Confirm Password" required="required">
			</div>
			<div class="form-group">
				<button class="btn btn-success btn-lg btn-block signup-btn" onclick="change();">Change</button>
			</div>
			<p>(영소문자 숫자 특수문자를 포함하는 8~15자)</p>
			<p class="hint-text small">
				<a id="backLogin" href="#">LOGIN 페이지로 이동</a>
			</p>
		</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script>
	document.querySelector('#backLogin').onclick = function() {
		window.open('http://localhost:8787/vgan/member/goin','login', 'width=800, height=1400, left=320px, top=150px');
		location.href = 'http://localhost:8787/vgan/welcome';
	}
	
	var user = "${user}";
	
	function change() {
		var pw = document.querySelector('#password').value;
		var pwcheck = document.querySelector('#pwdcheck').value;
		if(pw == pwcheck) {
			$.ajax({
				url: "http://localhost:8787/vgan/member/changepw",
				data: {
					"userEmail": user,
					"userPw": pw,
				},
				type: 'post',
				success: function(v) {
					if(v > 0) {
						alert("비밀번호 변경에 성공했습니다. 메인페이지로 이동합니다.");
						opener.location.href = 'http://localhost:8787/vgan/welcome';
						window.close();
					} else {
						alert("비밀번호 변경에 실패했습니다. 다시 시도해주세요.");
					}
					
				}
			})
		} else {
			alert('비밀번호가 일지하지 않습니다.');
		}
	}
</script>
</body>
</html>