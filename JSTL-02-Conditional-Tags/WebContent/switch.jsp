<%@ page  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgreen">
<div align='center'>
	<form action="./switch.jsp">
	<select name = "choice">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		
	</select>
	<input type="submit">
	</form>
	<c:set value="${param.choice }" var="day" />
	<c:choose>
		<c:when test="${day==1 }">
			<c:out value="SUNDAY"></c:out>  
		</c:when>
		<c:when test="${day==2 }">
			MONDAY
		</c:when>
		<c:when test="${day==3 }">
			TUESDAY
		</c:when>
		<c:when test="${day==4 }">
			WEDNESDAY
		</c:when>
		<c:when test="${day==5}">
			THRUSDAY
		</c:when>
		<c:when test="${day==6 }">
			FRIDAY
		</c:when>
		<c:when test="${day==7 }">
			SATARDAY
		</c:when>
		<c:otherwise >
			<h1>Please Select Number b/w 1 to 7</h1>
		</c:otherwise>
	</c:choose>
	
</div>
</body>
</html>