<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align:center" bgcolor="lightblue">
	<h1>iNeuron</h1>
	<c:url value="./second.jsp" var="x" scope="request">
	<c:param name="name" value="Nitin Sir"></c:param>
	
	</c:url>
	<h1>The modified url is : :</h1>
	<a href="${x }">Go to next page</a>
	
	
	
		
</body>
</html>