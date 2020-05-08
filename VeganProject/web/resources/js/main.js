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
				imgFluid.src = "/vgan/resources/image/after/portfolio/" + menuArr[i].메뉴아이디 + ".jpg";
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


var menuId;
var index = 0;
function menuInfoBox() {
	var menuName = document.querySelector('#infoMenuName');
	var menuPrice = document.querySelector('#infoMenuPrice');
	var restName = document.querySelector('#infoRestName');
	var restLoc = document.querySelector('#infoRestLoc');
	var restCell = document.querySelector('#infoRestCell');
	var restHour = document.querySelector('#infoRestHour');
	var area = document.querySelector('.area');
	
	document.querySelectorAll(".menuWrapper").forEach(function(el) {
		el.addEventListener("click", function(v) {
			menuId = menuArr[el.id].메뉴아이디;
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
			area.value = "";
			getReview();
		})
	})
}



// 혜영 리뷰
var arr = null;

function getReview() {
	if (index < 0) {
		alert('첫 페이지입니다.');
		index = 0;
	} else {
		$.ajax({
			url : 'http://localhost:8787/vgan/info/getreview',
			data : {
				"menuId" : menuId,
				"index" : index
			},
			type : "post",
			success : function(v) {
				var jObj = JSON.parse(v);
				if(jObj.length > 0) {
					arr = new Array;
					for(i = 0; i < jObj.length; i++) {
						arr.push(jObj[i]);
					}
				} else {
					arr = null;
				}
			}
		})

		.done(function() {
			var mediaList = document.querySelector('.media-list');
			mediaList.innerHTML = "";
			var revNo = 1;
			if(arr !=  null) {
				if(arr.length > 0) {
					for (i = 0; i < arr.length; i++) {
						var mediaLi = document.createElement('li');
						var userImgURL = document.createElement('a');
						var userImg = document.createElement('img');
						var mediaBody = document.createElement('div');
						var wellLg = document.createElement('div');
						var mediaUserName = document.createElement('h4');
						var dateWrapper = document.createElement('ul');
						var dateDay = document.createElement('li');
						var dateMonth = document.createElement('li');
						var dateYear = document.createElement('li');
						var mediaCont = document.createElement('p');
						
						mediaLi.className = 'media';
						userImgURL.className = 'pull-left';
						userImgURL.href = '#';
						userImg.className = 'media-object img-circle';
						userImg.src = "https://s3.amazonaws.com/uifaces/faces/twitter/dancounsell/128.jpg";
						userImg.alt = 'profile';
						mediaBody.className = 'media-body';
						wellLg.className = 'well well-lg';
						mediaUserName.id = 'revUserName';
						mediaUserName.className = 'media-heading text-uppercase reviews';
						dateWrapper.className = 'media-date text-uppercase reviews list-inline';
						dateDay.className = 'dd';
						dateMonth.className = 'mm';
						dateYear.className = 'aaaa';
						mediaCont.id = 'revUserCont';
						mediaCont.className = 'media-comment';
						
						var dateArr = arr[i].revDate.split(" ");
						var mm = dateArr[0].substring(0, dateArr[0].length-1);
						if(mm < 10) {
							mm = '0' + mm;
						}
						var dd = dateArr[1].substring(0, dateArr[0].length-1);
						if(dd < 10) {
							dd = '0' + dd;
						}
						
						mediaUserName.textContent = arr[i].nickName;
						mediaCont.textContent = arr[i].revContent;
						dateDay.textContent = dd;
						dateMonth.textContent = mm;
						dateYear.textContent = dateArr[2];
						
						mediaList.appendChild(mediaLi);
						mediaLi.appendChild(userImgURL);
						userImgURL.appendChild(userImg);
						mediaLi.appendChild(mediaBody);
						mediaBody.appendChild(wellLg);
						wellLg.appendChild(mediaUserName);
						wellLg.appendChild(dateWrapper);
						dateWrapper.appendChild(dateDay);
						dateWrapper.appendChild(dateMonth);
						dateWrapper.appendChild(dateYear);
						wellLg.appendChild(mediaCont);
					}
				}
			} else if(index = 0) {
				var div = document.createElement('div');
				div.textContent = "아직 등록된 리뷰가 없습니다.";
				mediaList.appendChild(div);
			} else {
				alert("마지막 페이지입니다.");
			}
		})
	}
}

var star = 0;
var starArr = document.querySelectorAll('.star');

starArr.forEach(function(el) {
	el.addEventListener('click', function() {
		for (i = 0; i < starArr.length; i++) {
			starArr[i].src = 'http://localhost:8787/vgan/resources/image/after/portfolio/starN.png';
		}

		for (i = 0; i < el.id; i++) {
			starArr[i].src = 'http://localhost:8787/vgan/resources/image/after/portfolio/starY.png';
		}

		star = (el.id).substr(1);
	})
})

var content = document.querySelector('.area');
function addReview() {
	$.ajax({
		url : 'http://localhost:8787/vgan/info/addreview',
		data : {
			"star" : star,
			"menuId" : menuId,
			"content" : content.value
		},
		type : 'post',
		success : function(v) {
			if (v > 0) {
				alert('리뷰가 정상적으로 저장되었습니다.');
			} else {
				alert('리뷰 작성 실패! 지속적으로 발생 시 고객센터로 문의 바랍니다.');
			}
		}
	})
	
	.done(function() {
		getReview();
	})
}
