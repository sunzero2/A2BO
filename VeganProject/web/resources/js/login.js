var idCheckFlag = false;
var span = document.querySelector('#pwdSpan');
var check = document.querySelector('#checkSpan');
var isSuccess = true;

function emailCheck() {
	$.ajax({
		url: "/vgan/member/check",
		type: 'get',
		data: $('#userEmail').serialize(),
		success: function(data) {
			if(data != '') {
				alert("이미 가입된 계정입니다.");
				idCheckFlag = false;
			} else {
				alert("사용 가능한 계정입니다.");
				idCheckFlag = true;
			}
		}
	})
}
	
function validate() {
	if(!isSuccess) {
		alert("비밀번호를 확인하세요.");
	}
	
	return isSuccess;
}

document.querySelector('#userPwd').onkeydown = function(v) {
	var pw = document.querySelector('#userPwd');
	var regExpPw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,15}$/;
	var testStr = pw.value + v.key;
	
	function chk(re, e, msg) {
		if(re.test(e)) {
			span.style.display = 'none';
			isSuccess = true;
		} else {
			span.style.display = 'block';
			span.style.color = 'red';
			span.textContent = msg;
			isSuccess = false;
		}
	}

	if(chk(regExpPw, testStr, '비밀번호를 확인하세요.')) {
		isSuccess = false;
	}
}


document.querySelector('#pwdCheck').onkeydown = function(v) {
	var pw = document.querySelector('#userPwd');
	var ch = document.querySelector('#pwdCheck');
	var testStr = ch.value + v.key;
	
	if(testStr == pw.value) {
		check.style.display = 'block';
		check.style.color = 'blue';
		check.textContent = "비밀번호가 일치합니다.";
		isSuccess = true;
	} else {
		check.style.display = 'block';
		check.style.color = 'red';
		check.textContent = "비밀번호가 일치하지 않습니다.";
		isSuccess = false;
	}
}
			