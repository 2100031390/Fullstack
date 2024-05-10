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

function loadEvents()
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

function loadList()
{
	var url = "http://localhost:8083/pet/participants/" + D1.value;
	callApi("GET", url, "", generateTable);
}

function generateTable(res)
{
	var data = JSON.parse(res);
	var table = `<table border="1px">
				 	<tr>
				 		<th>ID</th>
				 		<th>NAME</th>
				 		<th>CONTACT#</th>
				 		<th>EMAIL</th>
				 		<th>ADDRESS</th>
				 		<th>USERNAME</th>
				 		<th>PASSWORD</th>
				 	</tr>`;
	for(var x in data)
	{
		table += `<tr>
					<td>`+ data[x].id +`</td>
					<td>`+ data[x].name +`</td>
					<td>`+ data[x].contact +`</td>
					<td>`+ data[x].email +`</td>
					<td>`+ data[x].address +`</td>
					<td>`+data[x].username+`</td>
					<td>`+data[x].password+`</td>
				  </tr>`;
	}
	table += `</table>`;
	disp.innerHTML = table;
}