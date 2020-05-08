var reviewArr = null;
function getReview() {
	$.ajax({
		url: "http://localhost:8787/vgan/mypage/myreview",
		data: {
			"userId": myId
		},
		type: "post",
		success: function(v) {
			var jObj = JSON.parse(v);
			
			if(jObj.length > 0) {
				reviewArr = new Array();
				for(i = 0; i < jObj.length; i++) {
					reviewArr.push(jObj[i]);
				}
			} else {
				reviewArr = null;
			}
		}
	})
	
	.done(function() {
		var mediaList = document.querySelector('.media-list');
		mediaList.innerHTML = "";
		console.dir(reviewArr);
		if(reviewArr != null) {
			if(reviewArr.length > 0) {
				for(i = 0; i < reviewArr.length; i++) {
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
					var change = document.createElement('button');
					var deleteBtn = document.createElement('button');
					
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
					change.className = 'btn btn-primary btn-sm text-uppercase js-scroll-trigger';
					deleteBtn.className = 'btn btn-primary btn-sm text-uppercase js-scroll-trigger';
					
					var dateArr = reviewArr[i].revDate.split(" ");
					var mm = dateArr[0].substring(0, dateArr[0].length-1);
					if(mm < 10) {
						mm = '0' + mm;
					}
					var dd = dateArr[1].substring(0, dateArr[0].length-1);
					if(dd < 10) {
						dd = '0' + dd;
					}
					
					mediaUserName.textContent = reviewArr[i].nickName;
					mediaCont.textContent = reviewArr[i].revContent;
					dateDay.textContent = dd;
					dateMonth.textContent = mm;
					dateYear.textContent = dateArr[2];
					change.textContent = '수정하기';
					deleteBtn.textContent = '삭제하기';
					deleteBtn.style.marginLeft = '10px';
					
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
					wellLg.appendChild(change);
					wellLg.appendChild(deleteBtn);
				}
			}
		} else {
			alert("아직 등록한 리뷰가 없습니다.");
		}
	})
}
