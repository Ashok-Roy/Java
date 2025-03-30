<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="student" class="in.ineuron.bean.Student">
	
	<jsp:setProperty property="sid" name="student" value="101"/>
	<jsp:setProperty property="name" name="student" value="Dhoni"/>
	<jsp:setProperty property="address" name="student" value="IND"/>
	<jsp:setProperty property="age" name="student" value="49"/>
	
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Action</title>
</head>
<body bgcolor="lightgreen">
	<div align='center'>
	<h1 style="color:blue" >Student Details</h1>
		<table border='1'>
			<tr>
				<td>SID</td>
				<td> <jsp:getProperty property="sid" name="student"/> </td>
			</tr>
			<tr>
				<td>Name</td>
				<td> <jsp:getProperty property="name" name="student"/> </td>
			</tr>
			<tr>
				<td>Address</td>
				<td> <jsp:getProperty property="address" name="student"/> </td>
			</tr>
			<tr>
				<td>Age</td>
				<td> <jsp:getProperty property="age" name="student"/> </td>
			</tr>
		</table>
	</div>
</body>
</html>