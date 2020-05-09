<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/vgan/resources/css/styles.css" rel="stylesheet" />
<!-- <link rel="stylesheet" href="/vgan/resources/css/login.css" /> -->
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
body {
   font-family: 'Varela Round', sans-serif;
   background-image: url("/vgan/resources/image/after/mbgimge2.jpg");
}

.modal-login {
   width: 500px;
   height: 400px;
}

.modal-login .modal-content {
   padding: 150px 80px 50px 80px;
   border-radius: 25px;
   border: none;
   background-image: url("/vgan/resources/image/after/mbgimgesmallV.jpg");
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
   position:absolute;
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
</style>
</head>
<body>
   <!-- Modal HTML -->
      <div class="modal-dialog modal-login">   
         <div class="modal-content">
            <div class="modal-header">
               <img class="modal-header-logo"
                  src="/vgan/resources/image/after/vganlogo-1w.png">
               <button type="button" class="close" data-dismiss="modal"
                  aria-hidden="true">x</button>
               <h4 class="modal-title">Sign in</h4>
            </div>
            <div class="modal-body">
               <form action="/vgan/member/login" method="post">
                  <div class="form-group">
                     <input name="userEmail" type="text" class="form-control" placeholder="Username"
                        required="required">
                  </div>
                  <div class="form-group">
                     <input name="userPwd" type="password" class="form-control"
                        placeholder="Password" required="required">
                  </div>
                  <div class="form-group">
                     <input type="submit" class="btn btn-primary btn-block btn-lg"
                        value="Sign in">
                  </div>
               </form>
               <p class="hint-text small">
                  <a href="/vgan/member/searchmem">Forgot Your Password?</a><a href="/vgan/member/searchmem"> / Forgot
                     Your ID?</a>
               </p>
            </div>
            <div class="or-seperator">
               <b>or</b>
            </div>

            <div class="modal-body" id="modal-body-accnt">
            <div class="modal-header">
                  <h4 class="modal-title">New Account</h4>
                  <br><br>
                  </div>
               <form action="/vgan/member/join" method="post">
                  <br>
                  <div class="form-group">
                     <input type="text" class="form-control" name="username"
                        placeholder="Username" required="required">
                  </div>
                  <div class="form-group">
                     <input type="email" class="form-control" name="userEmail"
                       id="userEmail" placeholder="id" required="required">
                  </div>
                  <div class="form-group">
                     <input type="password" class="form-control" name="userPw"
                       placeholder="Password" required="required">
                  </div>
                  <div class="form-group">
                     <input type="password" class="form-control"
                        id="pwdCheck"  placeholder="Confirm Password"
                        required="required">
                  </div>
                  <div class="form-group">
                     <button type="submit"
                        class="btn btn-success btn-lg btn-block signup-btn">Sign
                        Up</button>
                  </div>
               </form>
            </div>
         </div>
      </div>
</body>
</html>