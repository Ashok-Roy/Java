<%@page import="in.visiontech.dto.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employee Data</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body bgcolor="lightgreen">
<%@include file="./index.jsp" %>
<div align="center">
	<caption><h3>List of Employee</h3></caption>
	
    <table border="1" class="table" id="alldataTable">
       		<thead class="thead-dark">
    			<tr>
       			<th>ID</th>
       			<th>Name</th>
       			<th>Email</th>
      		 	<th>City</th>
       			<th>Action</th>
    			</tr>
  			</thead>
            <c:forEach var="employee" items="${newlist}">
               <tr>
                    <td><c:out value="${employee.getEid()}" /></td>
                    <td><c:out value="${employee.getEname()}" /></td>
                    <td><c:out value="${employee.getEmail()}" /></td>
                    <td><c:out value="${employee.getCity()}" /></td>
                    <td>
                    <c:set var="n" value="${employee.getEname()}"></c:set>
                    <c:set var="e" value="${employee.getEmail()}"></c:set>
                    <c:set var="c" value="${employee.getCity()}"></c:set>
                   		 <a href="./update.jsp?id=<c:out value="${employee.getEid()}"/>&n=<c:out value="${n}"/>&e=<c:out value="${e}"/>&c=<c:out value="${c}"/>">Update</a>              
                    </td>
              </tr>
        </c:forEach>
        <tbody></tbody>
    </table>

</div>  
<br>
 <div align="center" class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
     <button type="submit" class="btn btn-primary btn-lg" onclick="window.location.href = 'http://localhost:8080/DynamicCURDApp/index.jsp';">Back</button>
 </div> 
 
</body>
</html>