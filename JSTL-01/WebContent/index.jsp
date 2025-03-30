<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgreen">
<div align="center">
	<!-- input as : http://localhost:8080/JSTL-01/index.jsp?user=Nitin&password=1234 --> 
	<c:out value="WELCOME TO JSTL PROGRAMMING"></c:out><br>
	The user name is :: <c:out value="${param.user}"></c:out><br>
	The user password is :: <c:out value="${param.password}"></c:out>
</div>
</body>
</html>