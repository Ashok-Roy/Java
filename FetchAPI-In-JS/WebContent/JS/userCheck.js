// Checking user is same or not
// getting the value using key and check the value is "secret" or not
	// if "secret" then do nothing if not redirect to login.jsp
	// if user want to come in index page this will prevent user and send back to login page
	// because key="code" value="" will be null 
	var code = localStorage.getItem("code");
	console.log(code);
	if(code ==="secret")
	{
		
	}else{
		window.location.href="index.jsp";
	}