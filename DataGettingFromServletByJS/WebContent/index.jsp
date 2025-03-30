<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <script src=".\\JS\\script.js"></script>
</head>
<body>
 <h1>Servlet Fetch Example</h1>
    <div id="output"></div>
    <script>
        
        fetch("MyServlet")
        .then(response => response.json())
        .then(data => {
            // Process the JSON data here
            for(var i = 0; i<=data.length; i++)
            	{
            		console.log(data[i]);
            	
            	}
            
        })
        .catch(error =>{ console.error(error)});
    </script>
</body>
</html>