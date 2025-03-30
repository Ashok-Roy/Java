<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body bgcolor="lightgreen">
<%@include file="./welcome.jsp" %>
<div align="center">
<table class="table table-striped" id="employeeTable" cellspacing="5">
  <thead>
  </thead>
  <tbody>
  	<tr>
  	</tr>
  </tbody>
</table>
</div>


<div align="center">
<h1>Search Data</h1>
<form id="myForm">
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationServer01">Enter Valid ID</label>
      <input type="text" class="form-control is-valid" id="id" name="eid" required>
      <div class="valid-feedback">
        Id please!
      </div>
    </div>
  </div>
  <button class="btn btn-primary" id ="searchButton"type="submit">Search</button>
   <button class="btn btn-primary"  type="button" style='margin-right:16px' onclick="window.location.href = 'http://localhost:8080/FetchAPI-In-JS/welcome.jsp';">Back</button>
</form>
</div>
<script src=".\\JS\\userCheck.js"></script>
<script src=".\\JS\\search.js"></script>
</body>
</html>