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

<c:set var="i" value="23"></c:set>
value of i is
<c:out value="${i }"></c:out>
<c:remove var="i"/><br>
value of i is
<c:out value="${i }"></c:out><br>

<c:forEach var="j"  begin="1" end="5">
value of j is<c:out value="${j}"></c:out><br>

</c:forEach>

<br>
<c:set var="k" value="10"></c:set>
<c:choose>
	<c:when test="${k==1 }"> Sunday </c:when>
	<c:when test="${k==2 }">Monday</c:when>
	<c:otherwise>Default Value</c:otherwise>

</c:choose>

<hr>

<c:set var="a" value="2"></c:set>
<c:if test="${a==1}">Hello World</c:if>

<c:url var="myurl" value="http://www.google.com/search">
	<c:param name="q" value="Java tutorial"></c:param>

</c:url>
<c:redirect url="${myurl }"></c:redirect>

</body>
</html>