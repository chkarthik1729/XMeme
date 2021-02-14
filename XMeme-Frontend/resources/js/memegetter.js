var container;
const pageSize = 10;
var currPage = -1;

async function loadNextPage() {
	container = document.querySelector(".card-columns");
	currPage++;
	fetch(apiURL + "?page=" + currPage + "&pageSize=" + pageSize, { method: "GET", })
	.then(response => response.json())
	.then(data => {
		if (data.length == 0) {
			currPage--;
			return;
		}
		data.forEach(addCard);
	});
}

function addCard(item) {
	var card = getNewCard();
	card.querySelector(".id").innerHTML = item.id;
	card.querySelector(".name").innerHTML = item.name;
	card.querySelector(".caption").innerHTML = item.caption;
	card.querySelector(".image").src = item.url;
	container.appendChild(card);
}

function getNewCard() {
	var card = document.createElement('div');
	card.className = "card";
	card.innerHTML = 
		"<div class\"card-body\">"
	  + "<div class =\"id\" hidden></div>"
	  + "<h3 class=\"name card-title ml-3 mt-2\"></h3>"
	  + "<p class=\"caption card-text ml-3\"></p>"
	  + "<img class=\"image card-img\">"
	  + "</div>";
	return card;
}