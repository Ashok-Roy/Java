<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Hit Count</title>
</head>
<body>
	<%
	//Write a program to count the hit of the application
	// Intentionally we are setting first count as null using getAttribute()
	// When 1st user will come count is null then if block will execute, count =1
	// 2nd user will come count already 1 so else block count = 2
	// 3rd user count = 3 like this so on
	// It will count the hit from the user, user may same or different 		
		Integer count = (Integer)application.getAttribute("hitcount");
		if(count == null)
			count = 1;
		else
			count++;
		application.setAttribute("hitcount", count);	
	%>
	<h1>Hit count of the application is : <%= count %></h1>
</body>
</html>