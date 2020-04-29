function callIframe() {
	var screenDiv = document.querySelector('.screenDiv');
	var innerDiv = document.querySelector('.innerDiv');
	var beforeTd = null;
	
	document.querySelector('.closeBtn').addEventListener('click', function(v) {
		screenDiv.style.display = "none";
		innerDiv.style.display = "none";
	})
	
	document.querySelectorAll('td').forEach(function(el) {
		el.addEventListener('click', function(v) {
			if(v.target.className != "tdTitle" && v.target.localName != 'label') {
				screenDiv.style.display = "block";
				innerDiv.style.display = "block";
				
				var yearmonth = document.querySelector('#yearmonth').innerHTML;
				var day = v.target.innerText;
				console.dir(v.target.innerText);
				var date = yearmonth + " " + day + "일";
				if(day < 10) {
					var inputDate = yearmonth + "0" + day;
				} else {
					var inputDate = yearmonth + day;
				}
				
				addTitle(date, inputDate);
				v.target.style.background = "#e1ff94";
				if(beforeTd != null) {
					beforeTd.style.background = "white";
				}
			}
			beforeTd = v.target;
		})
	})
}

function addTitle(date, inputDate) {
	var body = document.querySelector('.iframe').contentWindow.document.body;
	body.children[0].children[0].children[0].innerHTML = date;
	console.dir(body.children[0].children[0]);
	body.children[0].children[0][14].value = inputDate;
}