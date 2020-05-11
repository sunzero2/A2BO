<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		background-image: url("http://192.168.10.20:8787/vgan/resources/image/after/mbgimge15.jpg");
		background-size:100%; 
		background-repeat:no-repeat;
	
}

.modal-login {
	width: 160px;
    height: 400px;
    top: 10%;
    left: 3%;
    position: fixed;
}

.modal-login .modal-content {
	padding: 30px 30px 30px 30px;
	border-radius: 25px;
	border: none;
	background: blanchedalmond;
}

.modal-login .modal-header {
	border-bottom: none;
	position: relative;
	justify-content: center;
}

.modal-login h4 {
	text-align: center;
	font-size: 16px;
	font-weight: bold;
	color:#a077ff;
}

.modal-login .form-control, .modal-login .btn {
	min-height: 40px;
	border-radius: 30px;
	font-size: 15px;
	transition: all 0.5s;
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
    border-radius: 50%;
    height: 100px;
    width: 100px;
}

.modal-login .btn:hover, .modal-login .btn:focus {
	background: #8753ff;
}

.trigger-btn {
	display: inline-block;
	margin: 100px auto;
}

.modal-header-logo{
position: fixed;
top: 20%;
left:22%;
width:260px;
}
p{
font-size:13px;
color:#a077ff;
text-align:center;
margin-bottom:-10px;
}

a:link, a:visited {
    top: 45%;
    color: white;
    text-decoration: none;
    cursor: auto;
    text-align: center;
    position: relative;
}
.form-group{
margin-top:23px;

}
#cir1{
background: #f5b1cf;
border: none;
margin-bottom:10px;
}
#cir2{
background: #8cc5c1;
border: none;
margin-bottom:10px;

}
#cir3{
background: #ffc687;
border: none;
margin-bottom:10px;

}
#cir4{
background: #d8b0eb;
border: none;
margin-bottom:10px;

}

</style>
</head>
<body>

		<div class="modal-login">
			<div class="modal-content">
			
				<div class="modal-header">
					<h4 class="modal-title">M E N U</h4>
					<p>메뉴선택</p>
				</div>
				<div class="modal-body-pw">
						<div class="form-group">
						<div class="btn btn-success btn-lg btn-block signup-btn" id="cir1"><a href="/vgan/mypage/main">나의 리뷰</a></div>
						<div class="btn btn-success btn-lg btn-block signup-btn" id="cir2"><a href="/vgan/calendar/main">캘린더</a></div>
						<div class="btn btn-success btn-lg btn-block signup-btn" id="cir3"><a href="/vgan/mypage/inten">채식지향</a></div>
						<div class="btn btn-success btn-lg btn-block signup-btn" id="cir4"><a href="/vgan/mypage/privacy">정보수정</a></div>
				</div>
				</div>
				</div>
			</div>
</body>
</html>