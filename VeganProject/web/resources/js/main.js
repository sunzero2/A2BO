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

function ckclear() {
	var checkboxes = document.getElementsByName('ing');

	for (var i = 0; i < checkboxes.length; i++) {
		checkboxes[i].checked = false;
	}
}

// 체크박스 버튼 값 가져오는 기능
var menuArr;
function radiock() {
	var checkboxes = document.getElementsByName('ing');
	var str = [];
	var chkCnt = 0;

	for (var i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			str += checkboxes[i].value;
		}
	}
	// 3개만 선택하게끔 하는 기능
	for (var i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			chkCnt++;
		}
	}

	if (chkCnt == 0 || chkCnt == 1 || chkCnt == 2) {
		alert("3개만 선택하실수 있습니다.");
		magic;
	}

	$.ajax({
		url : "/vgan/main/searchingvg",
		type : 'get',
		data : {
			str : str
		},
		success : function(str) {
			document.querySelector('#myLevel').innerHTML = str;
		}
	})
	
	.done(function() {
		var menu;
		$.ajax({
			url : "/vgan/main/searchingmenu",
			type : 'get',
			data : {
				menu : menu
			},
			success : function(menu) {
				menuArr = new Array();
				var jObj = JSON.parse(menu);
				for (i = 0; i < jObj.length; i++) {
					menuArr.push(jObj[i]);
				}
			}
		})
		
		.done(function() {
			for(i = 0; i < menuArr.length; i++) {
				var row = document.querySelector('#row');
				var menuWrapper = document.createElement('div');
				var portfolioItem = document.createElement('div');
				var portfolioLink = document.createElement('a');
				var portfolioHover = document.createElement('div');
				var portfolioHoverContent = document.createElement('div');
				var portfolioIcon = document.createElement('i');
				var imgFluid = document.createElement('img');
				var portfolioCaption = document.createElement('div');
				var portfolioCaptionHeading = document.createElement('div');
				var portfolioCaptionSubheading = document.createElement('div');
	
				menuWrapper.className = "col-lg-4 col-sm-6 mb-4 menuWrapper";
				menuWrapper.id = i;
				portfolioItem.className = "portfolio-item";
				portfolioLink.className = "portfolio-link";
				portfolioLink.dataset.toggle = "modal";
				portfolioLink.href = "#menuInfo";
				portfolioHover.className = "portfolio-hover";
				portfolioHoverContent.className = "portfolio-hover-content";
				portfolioIcon.className = "fas fa-seedling fa-3x";
				imgFluid.className = "img-fluid";
				imgFluid.src = "/vgan/resources/image/after/portfolio/salad.jpg";
				portfolioCaption.className = "portfolio-caption"
				portfolioCaptionHeading.className = "portfolio-caption-heading";
				portfolioCaptionHeading.textContent = menuArr[i].메뉴이름;
				portfolioCaptionSubheading.className = "portfolio-caption-subheading";
				portfolioCaptionSubheading.textContent = menuArr[i].식당명;
				
				row.appendChild(menuWrapper);
				menuWrapper.appendChild(portfolioItem);
				portfolioItem.appendChild(portfolioLink);
				portfolioLink.appendChild(portfolioHover);
				portfolioHover.appendChild(portfolioHoverContent);
				portfolioHoverContent.appendChild(portfolioIcon);
				portfolioLink.appendChild(imgFluid);
				portfolioItem.appendChild(portfolioCaption);
				portfolioCaption.appendChild(portfolioCaptionHeading);
				portfolioCaption.appendChild(portfolioCaptionSubheading);
			}
			
			document.querySelectorAll('.col-lg-4').forEach(function(el) {
				el.style.display = "block";
			})
			
			menuInfoBox();
		})
	})
}

function menuInfoBox() {
	var menuName = document.querySelector('#infoMenuName');
	var menuPrice = document.querySelector('#infoMenuPrice');
	var restName = document.querySelector('#infoRestName');
	var restLoc = document.querySelector('#infoRestLoc');
	var restCell = document.querySelector('#infoRestCell');
	var restHour = document.querySelector('#infoRestHour');
	
	document.querySelectorAll(".menuWrapper").forEach(function(el) {
		el.addEventListener("click", function(v) {
			var after = menuArr[el.id].영업시간.replace("(", " ");
			after = after.replace(")", "");
			var hourArr = after.split(" ");
		
			for(i = 0; i < hourArr.length; i++) {
				switch(hourArr[i]) {
				case 'W-WD':
					hourArr[i] = '월-수';
					break;
				case 'M-WD':
					hourArr[i] = '월-수';
					break;
				case 'M-TH':
					hourArr[i] = '월-목';
					break;
				case 'W':
					hourArr[i] = '월-금';
					break;
				case 'M-SA':
					hourArr[i] = '월-토';
					break;
				case 'W-SA':
					hourArr[i] = '월-토';
					break;
				case 'TU':
					hourArr[i] = '화';
					break;
				case 'TU-F':
					hourArr[i] = '화-금';
					break;
				case 'TU-SA':
					hourArr[i] = '화-토';
					break;
				case 'TU-SU':
					hourArr[i] = '화-일';
					break;
				case 'WD-TH':
					hourArr[i] = '수-목';
					break;
				case 'WD-SA':
					hourArr[i] = '수-토';
					break;
				case 'F-SA':
					hourArr[i] = '금-토';
					break;
				case 'F-SU':
					hourArr[i] = '금-일';
					break;
				case 'SA':
					hourArr[i] = '토';
					break;
				case 'AS':
					hourArr[i] = '토';
					break;
				case 'SU':
					hourArr[i] = '일';
					break;
				case 'SU-TU':
					hourArr[i] = '일-화';
					break;
				case 'SU-WD':
					hourArr[i] = '일-수';
					break;
				case 'SU-TH':
					hourArr[i] = '일-목';
					break;
				case 'WE':
					hourArr[i] = '주말';
					break;
				case 'EW':
					hourArr[i] = '주말';
					break;
				case 'L':
					hourArr[i] = '점심';
					break;
				case 'H':
					hourArr[i] = '공휴일';
					break;
				case 'E':
					hourArr[i] = '매일';
					break;
				case 'L.O':
					hourArr[i] = 'LastOrder';
					break;
				case 'B.T':
					hourArr[i] = 'BreakTime';
					break;
				case 'NULL':
					hourArr[i] = '영업시간 비공개';
					break;
				}
			}
			
			var hour = "";
			for(i = 0; i < hourArr.length; i++) {
				hour += hourArr[i] + " ";
			}
			
			menuName.textContent = menuArr[el.id].메뉴이름;
			menuPrice.textContent = "￦" + menuArr[el.id].가격;
			restName.textContent = "Restaurant: " + menuArr[el.id].식당명;
			restLoc.textContent = "Location: " + menuArr[el.id].주소;
			if(menuArr[el.id].전화번호 == 'NULL') {
				restCell.textContent = "매장번호가 비공개인 식당입니다.";
			} else {
				restCell.textContent = "Cell: " + menuArr[el.id].전화번호;
			}
			restHour.textContent = "Opening: " + hour;
		})
	})
}
