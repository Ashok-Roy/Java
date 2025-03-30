function getData()
{
	fetch('./AllDataServlet').then(function(response){
		return response.json();
	}).then(function(data){
		let tab ='';
		for(var i = 0; i<data.length; i++)
			{
				// get one object data in one one array 
				var records = data[i];
				//console.log(records);
				//console.log(records.eid);
				tab += `<tr>
					<td>${records.eid}</td>
					<td>${records.ename}</td>
					<td>${records.email}</td>
					<td>${records.city}</td>
					</tr>`
				
			}
		// write this tab data inside tbody
		document.getElementById('tbody').innerHTML = tab;
		
		$(document).ready(function () {
		    $("#myTable").DataTable();
		});
	}).catch(function(error)
	{
		console.log("Opps! Some error: " + error);
	})


}