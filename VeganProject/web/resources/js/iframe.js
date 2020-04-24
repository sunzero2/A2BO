var screenDiv = document.querySelector('.screenDiv');
var innerDiv = document.querySelector('.innerDiv');

document.querySelector('.closeBtn').addEventListener('click', function(v) {
	screenDiv.style.display = "none";
	innerDiv.style.display = "none";
})

document.querySelectorAll('td').forEach(function(el) {
	el.addEventListener('click', function(v) {
		screenDiv.style.display = "block";
		innerDiv.style.display = "block";
	})
})
