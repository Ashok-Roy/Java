<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Hit Count</title>
</head>
<body>
<%
	//How many User login to the application
	// It will count only the new user
	
	Integer count = (Integer)application.getAttribute("userhit");
	if(session.isNew())
	{
		if(count == null)
			count = 1;
		else
			count++;
		
		application.setAttribute("userhit", count);
	}
	
%>
	<h1>User hit count is <%= count %></h1>
</body>
</html>