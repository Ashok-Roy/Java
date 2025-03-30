<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./second.jsp">
	<jsp:param value="Java" name="sub1"/>
	<jsp:param value="JDBC" name="sub2"/>
	<jsp:param value="JSP" name="sub3"/>
	<jsp:param value="Servlet" name="sub4"/>
	</jsp:include>
</body>
</html>