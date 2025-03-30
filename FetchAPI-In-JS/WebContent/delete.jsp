<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body bgcolor="lightgreen">
<%@include file="./welcome.jsp" %>
<div align="center">
<h1>Delete Data</h1>
<form id="myForm">
	<div>
		<input type="hidden" id="id" name="eid" >
	</div>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationServer01">Name</label>
      <input type="text" class="form-control is-valid" id="name" name="ename" disabled>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationServerUsername">Email</label>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend3">@</span>
        </div>
        <input type="text" class="form-control is-invalid" id="email" name="email" aria-describedby="inputGroupPrepend3" disabled>
      </div>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationServer01">City</label>
      <input type="text" class="form-control is-invalid" id="city" name="city" disabled>
    </div>
  </div>
  <button id="delete" class="btn btn-primary" type="submit">Delete</button>
</form>
</div>
<script src=".\\JS\\userCheck.js"></script>
<script src=".\\JS\\delete.js"></script>
</body>
</html>