
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%
	String str[] ={"sachin", "dhoni", "rahul"};
	pageContext.setAttribute("names", str);

%>

	<c:forEach var="name" items="${names }">
		<h3>Name is:: ${name}</h3><br>
	</c:forEach>

<hr style="width:50%; height:2px; ">

	<c:forEach begin="1" end="10" step="2" var="count">
		<h1>The value is ${count}</h1>
	</c:forEach>
</div>
</body>
</html>