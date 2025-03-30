<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    	
</head>
<body bgcolor="lightgreen">
<%@include file="./welcome.jsp" %>
<div align ="center">

<button class="btn btn-primary" id="showDataButton">Employee Data</button>

<br>
<br>
<table class="table table-striped table-bordered" id="employeeTable">
  <thead>
    
  </thead>
  <tbody>
  </tbody>
</table>
</div>
<script src=".\\JS\\userCheck.js"></script>
<script src=".\\JS\\alldata.js"></script>


</body>
</html>
