<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete By ID</title>
</head>
<body bgcolor="lightblue">
<%@include file="./index.jsp" %>
<div align="center">
<form action="./deleteServlet" method="post">

<%@include file="message.jsp" %>
<br>
	<table>
		
		<tr>
			<td><h3>Enter Your ID</h3></td>
		</tr>
		<tr>
			<td><input type="text" name="id" required="required"/></td>
		</tr>
	</table> 
	<div>
		<button type="submit" name="read">Delete</button>
		<button type="button" style='margin-right:16px' onclick="window.location.href = 'http://localhost:8080/DynamicCURDApp/index.jsp';">Back</button>
	</div>
</form>
</div>
</body>
</html>