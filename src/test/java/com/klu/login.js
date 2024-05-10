function callApi(METHOD, URL, DATA, SUCCESS)
{
	var xhttp = new XMLHttpRequest();
	xhttp.open(METHOD, URL, true);
	xhttp.setRequestHeader('Content-Type','application/json');
		
	xhttp.onreadystatechange = function()
	{
		if(this.readyState == 4)
		{
			if(this.status == 200)
				SUCCESS(this.responseText);
			else
				alert("404: Service unavailable");
		}
	};
	
	xhttp.send(DATA);
}


function loadAccessory()
{
	var url = "http://localhost:8083/pet/accessory";
	callApi("GET", url, "", loadDropDown);
}

function loadDropDown(res)
{
	var data = JSON.parse(res);
	for(var x in data)
	{
		var option = document.createElement("option");
		option.value = data[x].eid;
		option.text = data[x].ename;
		D1.add(option);
	}
}

function login()
{
	var url = "http://localhost:8083/pet/login";
	var data = JSON.stringify({
		username: T5.value,
		password:T6.value,
		eid : D1.value
	});
	callApi("POST", url, data, getResponse);
}

function getResponse(res)
{
	alert(res);
}
