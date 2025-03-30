<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>
	Page Scope Attribute :: <%= pageContext.getAttribute("p", 1) %><br>
	Request scope Attribute :: <%= pageContext.getAttribute("r", 2) %><br>
	Session Scope Attribute :: <%= pageContext.getAttribute("s", 3)%><br>
	Application Scope Attribute :: <%= pageContext.getAttribute("a", 4)%><br>
	
						Or<br>
	Page Scope Attribute ::	<%= pageContext.getAttribute("p") %><br>
	Request scope Attribute ::<%= request.getAttribute("r") %><br>
	Session Scope Attribute ::<%= session.getAttribute("s") %><br>
	Application Scope Attribute ::<%= application.getAttribute("a") %>
	
</h1>
</body>
</html>