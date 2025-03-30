<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var ="x" value="10" scope="page"/>
	<c:set var ="y" value ="20" scope="page"/>
	<c:set var ="z" value ="${x+y}" scope="session"/>
	<h1>The Result is : : <c:out value="${z}"></c:out></h1>
	
	<c:remove var="x"/>
	<c:remove var="y"/>
	<c:remove var="z"/>
	
	<h1>The Result is : : <c:out value="${z}"></c:out></h1>
	<!-- Get the default value -->
	<h1>The Result is : : <c:out value="${z}" default="1000"></c:out></h1>
	
</body>
</html>