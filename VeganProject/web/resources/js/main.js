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
					document.querySelector('.myLevel').innerHTML += menu;
				}
				
				
			})

}


function menuInfoBox(){
	document.querySelectorAll(".menuCard").forEach(function(el){
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
	


