document.getElementsByTagName("h1")[0].style.color="green";

var length = document.getElementsByTagName("h1").length;
console.log(length);	

document.getElementById("dataTables").innerHTML="Data Tables Using Objec Data ";


function getData()
{
	fetch('https://dummyjson.com/users')
	.then(function(response)
	{
		return response.json();
	})
	.then(function(data)
	{
		console.log(data);
		let tab='';
		data.users.forEach(function(records)
		{
			tab += `<tr>
				<td>${records.id}</td>
				<td>${records.firstName}</td>
				<td>${records.lastName}</td>
				<td>${records.maidenName}</td>
				<td>${records.age}</td>
				</tr>`;
		})
		
		document.getElementById("tbody").innerHTML = tab;
		
		// JQuery DataTables Code
		$(document).ready(function () {
		    $('#myTable').DataTable();
		});
	
		
		//or
		
//		$('#myTable').DataTable({
//			"data": data.users,
//			"columns": [
//				{"data" : "id"},
//				{"data" : "firstName"},
//				{"data" : "lastName"},
//				{"data" : "maidenName"},
//				{"data" : "age"},
//			]
//		})
		
	}).catch(function(error){
		console.log("Some Exception :" + error);
	})
}