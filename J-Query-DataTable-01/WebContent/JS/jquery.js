function getData()
{
	fetch('https://dummyjson.com/users')
	.then(function(response){
		return response.json();
	}).then(function(data){
		console.log(data);
		
		
		// use the data 
		let tab='';
		data.users.forEach(function(user){
			tab += `<tr>
				<td>${user.id}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.maidenName}</td>
				<td>${user.email}</td>
				<td>${user.gender}</td>			
				</tr>`
		})
		document.getElementById('tbody').innerHTML = tab;
		$('#myTable').DataTable({
			"data" : data.users,
			"columns":[
				{"data": 'id'},
				{"data": 'firstName'},
				{"data": 'lastName'},
				{"data": 'maidenName'},
				{"data": 'email'},
				{"data": 'gender'},
			]
		})
	})
	.catch(function(error){
		console.log("Opps! Some error " + error);
	})
	
}
