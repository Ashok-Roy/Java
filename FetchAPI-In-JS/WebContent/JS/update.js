// Update Operation JS code
 var urlParams = new URLSearchParams(window.location.search);
  console.log(urlParams);
 /* Get the id, name, email, city from url & set into variable */
  var id = urlParams.get("id");
  var name = urlParams.get("name");
  var email = urlParams.get("email");
  var city = urlParams.get("city");
  // printing in the console
  console.log(id);
  console.log(name);
  console.log(email);
  console.log(city);

  /* Get the data from var id = urlP.... & Setting data as like placeholder to <input id="email" */
 /* we can set directly also-> document.getElementById("name").value = urlParams.get("name"); */
  document.getElementById("id").value = id;
  document.getElementById("name").value = name;
  document.getElementById("email").value = email;
  document.getElementById("city").value = city;
  
  
  // send data to the servlet 
  const form = document.getElementById('myForm');
  form.addEventListener('submit', function(event) {
  	event.preventDefault(); // Prevent the form from submitting normally
  	const url = './UpdateServlet'; // Servlet url
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
      	 	alert("Updation Successful");
    	} else {
      		alert("Updation Failed!");
    	}
  //  alert("update successful");
  })
  .catch(error => {
    // Handle any errors that occur during the request
  });
});
