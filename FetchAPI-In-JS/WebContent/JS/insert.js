  
  // Insert The Data js code
 
  
  // send data to the servlet 
  const form = document.getElementById('myForm');
  form.addEventListener('submit', function(event) {
  	event.preventDefault(); // Prevent the form from submitting normally
  	const url = './InsertServlet'; // Servlet url
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
   		if (data.message === "success") {
      	 	alert("Insertion Successful");
    	} else {
      		alert("Insertion Failed!");
    	}
  //  alert("update successful");
  })
  .catch(error => {
    // Handle any errors that occur during the request
    console.log("Some error : "+ error);
  });
});
