function all(selector, ln) {
	if (arguments.length >= 2) {
		return document.querySelectorAll(selector);
	} else {
		return document.querySelector(selector);
	}
}
// 나의 단계가 나온 후에 메뉴 카드 리스트가 나오게 하는 기능
function create(vals) {
	var tr = document.createElement('tr');
	var td = document.createElement('td');

	vals.forEach(function (v) {
		var td = document.createElement('td');
		td.textContent = v.value;
		tr.appendChild(td);
	})

	var dtd = document.createElement('td');
	dtd.innerHTML = "<div class='menuImage'>" 
				   +"<img src='http://placehold.it/245x230'></div>" 
				   +"<div class='menuInfo'><div class='menuName'>메뉴 이름 : </div><div class='menuPoint'>별점 : </div>" 
				   +"<div class='menuAd'>주소 : </div><button class='ingBtn' onclick='menuInfoBox()'>버튼 상세보기</button>"
				   +"<a href='https://www.saramin.co.kr/zf_user/' target='menuIf'></a></div></div>"
	tr.appendChild(dtd);

	return tr;
}



// 메뉴 리스트 카드에서 상세보기 했을 때 아이프레임으로 나오게 하는 기능
function create2(vals) {
	var tr = document.createElement('tr');
	var td = document.createElement('td');
	
/*	vals.forEach(function (v) {
		var td = document.createElement('td');
		td.textContent = v.value;
		tr.appendChild(td);
	})
*/
	var dtd = document.createElement('td');
	dtd.innerHTML = "<div><div><button onclick='xbtn();'>x</button></div><iframe name='menuIf' class='menuIfram' src='https://www.iei.or.kr/main/main.kh'></iframe></div>"
	tr.appendChild(dtd);

	return tr;
}

function menuList() {
	var vals = all('input[type=text]', 1);
	all('.menuCard').appendChild(create(vals));
}

function menuInfoBox() {
	var vals = all('input[type=text]', 1);
	all('.menuInfoBox').appendChild(create2(vals));
}


function xbtn(){
	var menuInfoBox = document.querySelector('.menuInfoBox');
	menuInfoBox.close();
}

// 재료를 중복 3개를 초과해서 선택했을 경우 경고창이 뜨는 기능
function count_ck(obj) {

	var chkbox = document.getElementsByName("ing");
	var chkCnt = 0;
	for (var i = 0; i < chkbox.length; i++) {
		if (chkbox[i].checked) {
			chkCnt++;
		}
	}
	
	
	if (chkCnt >= 4) {
		alert("3개만 선택하실수 있습니다.");
		obj.checked = false;
		return false;
	}



}
function ckclear(){
	
	var checkboxes = document.getElementsByName('ing');
 	
	for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = false;
		}
	} 
	
	






// 체크박스 버튼 값 가져오는 기능
function radiock() {
	console.log("tq");
 	var checkboxes = document.getElementsByName('ing');
 	var str = [];
 	var chkCnt = 0;
	
	for (var i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			str += checkboxes[i].value;
		}
	} 
	//3개만 선택하게끔 하는 기능
	for (var i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			chkCnt++;
		}
	}
	
	if(chkCnt == 0 || chkCnt == 1 || chkCnt == 2){
		alert("3개만 선택하실수 있습니다.");
		magic;
	}

	// $("input[name=ing]:checked").each(function(i){   //jQuery로 for문 돌면서 check 된값 배열에 담는다
    //         str.push($(this).val());
    //           });

 	
	console.log(str);
	console.log(checkboxes);
	$.ajax({
				url: "/vgan/main/searchingVg",
				type: 'get',
				headers: {
					'Content-Type':'application/x-www-form-urlencoded'
				},
				data:{ 
					 str : str
				},
				 success: function(str) {
					document.querySelector('.myLevel').innerHTML = /* '<h1>당신의 비건 단계는' +myLevel + '입니다~</h1>' */str;
				} 
				/* ,error:function(request,status,error){
					alert("code:"+request.status+ "\n" +"message:"+request.responseText+  "\n" + "error:" + error);
				} */
				
			})

//	str.subString(str.length - 2, str.length);
//	alert(str + "를 선택하셨습니다.");
}

// & 나의 단계 나오게 하는 기 
/* function levelChose(){
	var myLevel1 = document.getElementsByName('myLevel');
	myLevel1.style.display = "block";

} */


/* function click() {
	console.log("tq");
	$.ajax({
		url: "/vgan/main/searchingVg",
		type: 'post',
		data: {
			"ing": "3"
		},
		success: function (f) {
			console.dir("ㅇㄹㄴㅇ린ㅇ리나얼")
		}
	}) 
} */
function menuList(){
	console.dir("dd");
		
	
	var menu;
	$.ajax({
				url: "/vgan/main/searchingMenu",
				type: 'get',
				headers: {
					'Content-Type':'application/x-www-form-urlencoded'
				},data :{
					menu : menu
				},
				
				success: function(menu) {
					console.dir("aa")
					document.querySelector('.menuList').innerHTML += menu;
				}
				
				
			})

}

