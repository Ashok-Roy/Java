<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="x" value="10" scope="request"/>
	<c:set var="y" value="20" scope="request"/>
	<c:set var="sum" value="${x+y}" scope="session"/>
	<h1 style='text-align:center'>
		The sum is :: <c:out value="${sum}"/>
	</h1>
	
</body>
</html>