var screenDiv = document.querySelector('.screenDiv');
var innerDiv = document.querySelector('.innerDiv');

// top.jsp 오른쪽 상단 버튼 부분 스크립트
document.querySelectorAll('.topLink').forEach(function(el) {
	el.addEventListener('click', function(v) {
		console.dir(v.target);
		if(v.target.text == '로그인' || v.target.text == '회원가입') {
			screenDiv.style.display = "block";
			innerDiv.style.display = "block";
		}
	})
})

// topLogo를 클릭하면 무조건 메인페이지로 이동
document.querySelector('.topLogo').addEventListener('click', function() {
	console.dir(v.target);
	location.href='localhost:8787/vgan/welcome';
})