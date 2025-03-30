// Log In code in JS

  
 
  // send data to the servlet 
  const form = document.getElementById('loginForm');
  form.addEventListener('submit', function(event) {
  	event.preventDefault(); // Prevent the form from submitting normally
  	const url = './LogInServlet'; // Servlet url
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
   			// Setting key value in localStorage for logout purpose 
   			localStorage.setItem("code","secret");
   			
      	 	alert("LogIn Successful");
      	 	// Redirect to another JSP page
      	 	window.location.href = "welcome.jsp";

    	} else {
      		alert("LogIn Failed! Please Enter Correct Details");
      		widow.location.href="index.jsp";
    	}
  //  alert("update successful");
  })
  .catch(error => {
    // Handle any errors that occur during the request
    console.log("Some error : "+ error);
  });
});
