var idCheckFlag = false;
function emailCheck() {
	$.ajax({
		url: "/vgan/member/check",
		type: 'get',
		data: $('#userEmail').serialize(),
		success: function(data) {
			if(data != '') {
				alert("이미 가입된 이메일입니다.");
				idCheckFlag = false;
			} else {
				alert("사용가능한 이메일입니다.");
				idCheckFlag = true;
			}
		}
	})
}
	
function validate() {
	var pw = $('#userPwd');
	var regExpPw = /(?=.*\d{1,50})(?=.*[~!@#$%\^&*()_+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}/;
				
	function chk(re, e, msg) {
		if(re.test(e.value)) {
			return true;
		} else {
			alert(msg);
			e.value = "";
			e.focus();
			return false;
		}
	}
				
	if(!idCheckFlag) {
		alert("아이디 중복 검사를 해주세요.");
		return false;
	} 
	
	if(chk(regExpPw, pass, '암호는 영문자, 숫자 조합으로 8글자 이상 15글자 이하로 작성해주세요')) {
		return false;
	}
				
	return true;
}
			