function $(selector, ln) {
	if (arguments.length >= 2) {
		return document.querySelectorAll(selector);
	} else {
		return document.querySelector(selector);
	}
}

function create(vals) {
	var tr = document.createElement('tr');
	var td = document.createElement('td');

	vals.forEach(function (v) {
		var td = document.createElement('td');
		td.textContent = v.value;
		tr.appendChild(td);
	})

	var dtd = document.createElement('td');
	dtd.innerHTML = "<div class='menuImage'><img src='http://placehold.it/245x230'></div><div class='menuInfo'><div class='menuName'>메뉴 이름 : </div><div class='menuPoint'>별점 : </div><div class='menuAd'>주소 : </div><button class='ingBtn' onclick='menuInfoBox()'>버튼 상세보기</button>"
		+ "<a href='https://www.saramin.co.kr/zf_user/' target='menuIf'>a태그 상세보기</a></div></div>"
	tr.appendChild(dtd);

	return tr;
}

function create2(vals) {
	var tr = document.createElement('tr');
	var td = document.createElement('td');

	vals.forEach(function (v) {
		var td = document.createElement('td');
		td.textContent = v.value;
		tr.appendChild(td);
	})

	var dtd = document.createElement('td');
	dtd.innerHTML = "<iframe name='menuIf' class='menuIfram'src='https://www.iei.or.kr/main/main.kh'></iframe>"
	tr.appendChild(dtd);

	return tr;
}

function menuList() {
	var vals = $('input[type=text]', 1);
	$('.menuCard').appendChild(create(vals));
}


function menuInfoBox(){
	var vals = $('input[type=text]', 1);
	$('.menuInfoBox').appendChild(create2(vals));
}