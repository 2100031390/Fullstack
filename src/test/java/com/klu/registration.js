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

function register()
{
  var url = "http://localhost:8083/pet/register";
  var data = JSON.stringify({
    name : T1.value,
    contact : T2.value,
    email : T3.value,
    institution : T4.value,
    address : T5.value,
    eid : D1.value
  });
  callApi("POST", url, data, getResponse);
}

function getResponse(res)
{
  alert(res);
}