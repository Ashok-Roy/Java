<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To Java Course</h1>
	<c:import url="./paramtwo.jsp">
		<c:param name="Java" value="Hyder Sir"></c:param>
		<c:param name="Spring" value="Nitin Sir"></c:param>
		<c:param name="Framework" value="Navin Sir"></c:param>
	
	</c:import>
</body>
</html>