<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
// Every user has there own session object 
// How many times a single user is hiting the application 
// 
	Integer count = (Integer)session.getAttribute("sessioncount");
	if(count == null)
		count = 1;
	else
		count++;
	session.setAttribute("sessioncount", count);

%>
<h1>The Hit count of the application is <%= count %></h1>
</body>
</html>