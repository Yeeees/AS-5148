var request = null;
var rooturl = "http://localhost:8080/ConferenceWeb/webresources/ConferenceREST.author";
function createRequest() {
    try {
        request = new XMLHttpRequest();
    } catch (trymicrosoft) {
        try {
            request = new ActiveXObject("MsXML2.XMLHTTP");
        } catch (othermicrosoft) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                request = null;
            }
        }
    }
    if (request == null)
        alert("Error creating request object!");
}

function getAllAuthor()
{
    document.getElementById('authroId').value = "";
    document.getElementById('authorFname').value = "";
    document.getElementById('authorLname').value = "";
    document.getElementById('authorAffiliation').value = "";
    document.getElementById('authorCountry').value = "";
    document.getElementById('authorEmail').value = "";
    document.getElementById('authorNumber').value = "";
    createRequest();
    request.onreadystatechange = handleListJSONResponse;
    request.open("GET", rooturl, true);
    request.send(null);
}


function getAuthor()
{
    document.getElementById("output").innerHTML = "";
    document.getElementById('authorFname').value = "";
    document.getElementById('authorLname').value = "";
    document.getElementById('authorAffiliation').value = "";
    document.getElementById('authorCountry').value = "";
    document.getElementById('authorEmail').value = "";
    document.getElementById('authorNumber').value = "";
    createRequest();
    var id = document.getElementById("authorId").value;
    var url = rooturl + "/" + id;
    request.onreadystatechange = handleJSONResponse;
    request.open("GET", url, true);
    request.send(null);
}
function addAuthor()
{
    document.getElementById("output").innerHTML = "";
    var authorId = document.getElementById('authorId').value;
    var authorFname = document.getElementById('authorFname').value;
    var authorLname = document.getElementById('authorLname').value;
    var authorAffiliation = document.getElementById('authorAffiliation').value;
    var authorCountry = document.getElementById('authorCountry').value;
    var authorEmail = document.getElementById('authorEmail').value;
    var authorNumber = document.getElementById('authorNumber').value;
    createRequest();
    var data = JSON.stringify({"authorId": authorId.toString(),
        "authorFname": authorFname.toString(),
        "authorLname": authorLname.toString(),
        "authorAffiliation": authorAffiliation.toString(),
        "authorCountry": authorCountry.toString(),
        "authorEmail": authorEmail.toString(),
        "authorNumber": authorNumber.toString(),
        
        });
    request.open("POST", rooturl);
    request.setRequestHeader('Content-type', 'application/json');
    request.setRequestHeader("Content-Length", data.length);
    request.setRequestHeader('Accept', 'application/json');
    request.send(data);
    document.getElementById('authorId').value = "";
    document.getElementById('authorFname').value = "";
    document.getElementById('authorLname').value = "";
    document.getElementById('authorAffiliation').value = "";
    document.getElementById('authorCountry').value = "";
    document.getElementById('authorEmail').value = "";
    document.getElementById('authorNumber').value = "";
}

function deleteAuthor()
{
    document.getElementById("output").innerHTML = "";
    createRequest();
    var id = document.getElementById("authorId").value;
    var url = rooturl + "/" + id;
    request.open("DELETE", url, true);
    request.send(null);
    document.getElementById('authorId').value = "";
    document.getElementById('authorFname').value = "";
    document.getElementById('authorLname').value = "";
    document.getElementById('authorAffiliation').value = "";
    document.getElementById('authorCountry').value = "";
    document.getElementById('authorEmail').value = "";
    document.getElementById('authorNumber').value = "";
}

function updateAuthor()
{
    document.getElementById("output").innerHTML = "";
    var authorId = document.getElementById('authorId').value;
    var authorFname = document.getElementById('authorFname').value;
    var authorLname = document.getElementById('authorLname').value;
    var authorAffiliation = document.getElementById('authorAffiliation').value;
    var authorCountry = document.getElementById('authorCountry').value;
    var authorEmail = document.getElementById('authorEmail').value;
    var authorNumber = document.getElementById('authorNumber').value;
    createRequest();
    var data = JSON.stringify({"authorId": authorId.toString(),
        "authorFname": authorFname.toString(),
        "authorLname": authorLname.toString(),
        "authorAffiliation": authorAffiliation.toString(),
        "authorCountry": authorCountry.toString(),
        "authorEmail": authorEmail.toString(),
    "authorNumber": authorNumber.toString()});
    var url = rooturl + "/" + docId;
    request.open("PUT", url);
    request.setRequestHeader('Content-type', 'application/json');
    request.setRequestHeader("Content-Length", data.length);
    request.setRequestHeader('Accept', 'application/json');
    request.send(data);
   document.getElementById('authorId').value = "";
    document.getElementById('authorFname').value = "";
    document.getElementById('authorLname').value = "";
    document.getElementById('authorAffiliation').value = "";
    document.getElementById('authorCountry').value = "";
    document.getElementById('authorEmail').value = "";
    document.getElementById('authorNumber').value = "";
}




function handleJSONResponse() {
    if (request.readyState == 4 && request.status == 200)
    {
        var det = JSON.parse(request.responseText);
        document.getElementById('authorId').value = det.authorId;
        document.getElementById('authorFname').value = det.authorFname;
        document.getElementById('authorLname').value = det.authorLname;
        document.getElementById('authorAffiliation').value = det.authorAffiliation;
        document.getElementById('authorCountry').value = det.authorCountry;
        document.getElementById('authorEmail').value = det.authorEmail;
        document.getElementById('authorNumber').value = det.authorNumber;
    }
}

function handleListJSONResponse() {
    if (request.readyState == 4 && request.status == 200)
    {
        var det = JSON.parse(request.responseText);
        var output = "<table border = '1'>";
        output += "<tr>" + "<th>authorId</th>" + "<th>authorFname</th>" + "<th>authorLname</th>"
                + "<th>authorAffiliation</th>" + "<th>authorCountry</th>" + "<th>authorEmail</th>" + "<th>authorNumber</th>"       
                + "</tr>";
        for (var i = 0; i < det.length; i++) {
            output += "<tr>";
            output += "<td>" + det[i].authorId + "</td>";
            output += "<td>" + det[i].authorFname + "</td>";
            output += "<td>" + det[i].authorLname + "</td>";
            output += "<td>" + det[i].authorAffiliation + "</td>";
            output += "<td>" + det[i].authorCountry + "</td>";
            output += "<td>" + det[i].authorEmail + "</td>";
            output += "<td>" + det[i].authorNumber + "</td>";
            output += "</tr>";
        }
        output += "</table>";
        document.getElementById("output").innerHTML = output;
    }
}

