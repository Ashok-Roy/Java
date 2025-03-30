// Search Operation JS Code

  // send data to the servlet 
  const form = document.getElementById('myForm');
  form.addEventListener('submit', function(event) {
  	event.preventDefault(); // Prevent the form from submitting normally
  	const url = './SearchServlet'; // Servlet url
  	const formData = new FormData(form); // Get the form data
  	const data = {}; // Create an object to hold the form data
  	formData.forEach(function(value, key) {
    data[key] = value; // Add each form field to the data object
  });
  const jsonData = JSON.stringify(data); // Convert data to JSON format
  fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: jsonData
  })
  .then(response => response.json())
   // Handle the response from the servlet
   	.then(data => {
   		console.log(data);
   		
   		//printing data in table
   		
   		if (data != null ) 
   		{
   			const values = Object.values(data);
   			console.log("control is here");
   		 	var tableHead = document.querySelector("#employeeTable thead");
   	  		var tableBody = document.querySelector("#employeeTable tr");

   			var head = '<tr>'+
	  			'<th scope="col">ID</th>'+
	  			'<th scope="col">NAME</th>'+
	  			'<th scope="col">EMAIL</th>'+
	  			'<th scope="col">CITY</th>'+
	  			'</tr>';
	 		 tableHead.insertAdjacentHTML('beforebegin', head);
   			for (var i = 0; i < values.length; i++)
   			{
    			//var employee = values[i];
    			//console.log("Employee data : " + employee);
     			var row ='<td style=" padding: 15px;"> ' + values[i]+ '</td>';
 				tableBody.insertAdjacentHTML('beforeend', row);
  			 }		
   			
   			// Disable the search button
   			var showDataButton = document.querySelector("#searchButton");
     		showDataButton.disabled = true;
   		  
   			
   			
    	}
   		else if(data === null){
      		alert("Record Not Found!");
    	} 
  })
  .catch(error => {
    // Handle any errors that occur during the request
    console.log("Some error: " + error);
  });
});
