<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Read Data</title>
</head>
<body bgcolor="lightgreen">
<%@include file="./index.jsp" %>
<div align="center">
<h3>Employee Details</h3>
	<table border="1">
		<tr>
			<td>ID</td>
			<td><%=  request.getAttribute("id")%></td>
		</tr>	
		<tr>
			<td>NAME</td>
			<td><%=  request.getAttribute("name")%></td>
		</tr>	
		<tr>
			<td>EMAIL</td>
			<td><%=  request.getAttribute("email")%></td>
		</tr>	
		<tr>
			<td>CITY</td>
			<td><%=  request.getAttribute("city")%></td>
		</tr>	
	</table>
	<br>
    <button type="submit" class="btn btn-primary btn-lg" onclick="window.location.href = 'http://localhost:8080/DynamicCURDApp/index.jsp';">Back</button>
</div>
	
</body>
</html>