<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
</head>
<body bgcolor="lightgreen">
<%@include file="./welcome.jsp" %>
<div align="center">
<h1>Insert Data</h1>
<form id="myForm">
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationServer01">Name</label>
      <input type="text" class="form-control is-valid" id="name" name="ename" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationServerUsername">Email</label>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend3">@</span>
        </div>
        <input type="text" class="form-control is-invalid" id="email" name="email"placeholder="Useremail" aria-describedby="inputGroupPrepend3" required>
        <div class="invalid-feedback">
          Please choose a username.
        </div>
      </div>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationServer01">City</label>
      <input type="text" class="form-control is-invalid" id="city" name="city" placeholder="City" required>
      <div class="invalid-feedback">
        Please provide a valid city.
      </div>
    </div>
  </div>
  <button id="update" class="btn btn-primary" type="submit">Submit form</button>
   <button class="btn btn-primary"  type="button" style='margin-right:16px' onclick="window.location.href = 'http://localhost:8080/FetchAPI-In-JS/welcome.jsp';">Back</button>
</form>
</div>
<script src=".\\JS\\userCheck.js"></script>
<script src=".\\JS\\insert.js"></script>
</body>
</html>