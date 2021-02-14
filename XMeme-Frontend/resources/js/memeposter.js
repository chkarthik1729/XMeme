const apiURL = "http://localhost:8081/memes/";

async function postMeme() {
	var submitButton = document.getElementById("submitButton");
	replaceWithSpinner(submitButton, "&nbsp;&nbsp;Posting...");
	disableButton(submitButton);

	var name = document.getElementById("name").value;
	var caption = document.getElementById("caption").value;
	var url = document.getElementById("url").value;
	var postAlert = document.getElementById("postalert");

	const response = await postRequest(apiURL, {
		name: name,
		caption: caption,
		url: url
	});

	if (!response.ok) {
		const data = await response.json();
		postAlert.className = "row alert alert-danger ml-auto mr-auto";
		postAlert.innerHTML = "Failed! " + data.message;
		postAlert.hidden = false;
	} else {
		const data = await response.json();
		postAlert.className = "row alert alert-success ml-auto mr-auto";
		postAlert.innerHTML = "Success!";
		postAlert.hidden = false;
	}

	setTimeout(function() {
		location.reload();
	}, 1000);
}

function postRequest(url, data) {
    const options = {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    }
    return fetch(url, options);
}

function disableButton(button) {
	button.disabled = true;
}

function enableButton(button) {
	button.disabled = false;
}

function replaceWithSpinner(button, extraText) {
    button.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>' + extraText;
}