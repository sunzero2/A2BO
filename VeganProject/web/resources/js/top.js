// top.jsp 오른쪽 상단 버튼 부분 스크립트
document.querySelectorAll('.topLink').forEach(function(el) {
	el.addEventListener('click', function(v) {
		if(v.target.text == '로그인' || v.target.text == '회원가입') {
			window.open('http://localhost:8787/vgan/member/goin','login', 'width=800, height=700, left=320px, top=150px');
		}
	})
})

// topLogo를 클릭하면 무조건 메인페이지로 이동
document.querySelector('.topLogo').addEventListener('click', function() {
	location.href='localhost:8787/vgan/welcome';
})