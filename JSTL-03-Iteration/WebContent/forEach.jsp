<%@page import="java.util.ArrayList"%>
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
	<%
		ArrayList<String> list = new ArrayList<>();
		list.add("sachin");
		list.add("dhoni");
		list.add("kholi");
		list.add("rahul");
		
		pageContext.setAttribute("names", list);
	
	%>
	<c:forEach var="name" items="${names }" >
		<h2>Name : ${name }</h2>
	</c:forEach>
</body>
</html>