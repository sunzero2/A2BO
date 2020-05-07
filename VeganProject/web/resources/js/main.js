function all(selector, ln) {
	if (arguments.length >= 2) {
		return document.querySelectorAll(selector);
	} else {
		return document.querySelector(selector);
	}
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
var menuArr;
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
					menuArr = new Array();
					var jObj = JSON.parse(menu);
					for(i = 0; i < jObj.length; i++) {
						menuArr.push(jObj[i]);
					}
					/*console.dir("aa")
					document.querySelector('.myLevel').innerHTML += menu;*/
				}
			})
			
	.done(function() {
		var wrapper = document.querySelector('#portfolio');
		for(i = 0; i < menuArr.length; i++) {
			
			console.dir(menuArr[i].메뉴이름);
			var menuCard = document.createElement('div');
			var menuName = document.createElement('div');
			var restName = document.createElement('div');
			
			menuCard.className = "menuCard";
			menuCard.id = i;
			menuName.className = "menuName";
			restName.className = "restName";
			
			menuName.textContent = menuArr[i].메뉴이름;
			restName.textContent = menuArr[i].식당명;
			
			wrapper.appendChild(menuCard);
			menuCard.appendChild(menuName);
			menuCard.appendChild(restName);
		}
	})
// "<div class='menuCard'>" + 
//    		  "<div class='menuName'><h1>" + menu.get(i).get("메뉴이름") + "</h1></div>" +
//    		  "<div class='menuId'>" + menu.get(i).get("메뉴아이디") +"</div>" + 
//    		  "<div class='menuPri'>가격 : " + menu.get(i).get("가격") + "원</div>" + 
//    		  "<div class='revStarrate' >별점 : " + "" + "</div>" + 
//    		  "<div><h3>******* 매장 소개********</h3></div>" + 
//    		  "<div class='restName'>" + menu.get(i).get("레스트 이름")  + "</div>" + 
//    		  "<div class='menuLocation'>주소 : " + menu.get(i).get("주소") + "</div>" + 
//    		  "<div class='restPhone'>전화번호 : " + menu.get(i).get("전화번호") + "</div>" + 
//    		  "<div class='restHour'>영업시간 : " + menu.get(i).get("영업시간") + "</div>" +
//    		  "<button class='ingBtn' onclick='menuInfoBox()'>메뉴 상세보기</button>" + 
//    		 "</div>"
}


function menuInfoBox(){
	document.querySelectorAll("#menuCard").forEach(function(el){
		el.addEventListener("click", function(v){
			/*document.querySelector('.bbb').textContent = el.value;*/
			
			console.dir(el.children[0].textContent);
			console.dir(el.children[1].textContent);
			console.dir(el.children[2].textContent);
			console.dir(el.children[3].textContent);
			console.dir(el.children[4].textContent);
			console.dir(el.children[5].textContent);
			console.dir(el.children[6].textContent);
			console.dir(el.children[7].textContent);
			console.dir(el.children[8].textContent);
			console.dir(el.children[9].textContent);
		
			
			
			var bbb = document.querySelector('.bbb');
			/*.innerHTML = "<input name='menuName' type='hidden'>" + el.children[0].textContent
													+ "<input name='menuId' type='hidden'>" + el.children[1].textContent
													+"<input name='menuPri' type='hidden'>" + el.children[2].textContent
													+"<input name='restName' type='hidden'>" + el.children[3].textContent
													+"<input name='menuLocation' type='hidden'>" + el.children[6].textContent
													+"<input name='restPhone' type='hidden'>" + el.children[7].textContent
													+"<input name='restHour' type='hidden'>" + el.children[8].textContent;*/
													
			bbb.children[0].value = el.children[0].textContent;
			bbb.children[1].value = el.children[1].textContent;
			bbb.children[2].value = el.children[2].textContent;
			bbb.children[3].value = el.children[3].textContent;
			bbb.children[4].value = el.children[6].textContent;
			bbb.children[5].value = el.children[7].textContent;
			bbb.children[6].value = el.children[8].textContent;
			
			bbb.submit();
			
			
	})
		
	})
}
	


