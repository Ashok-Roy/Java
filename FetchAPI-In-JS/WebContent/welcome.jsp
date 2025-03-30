<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NavBar</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">CURD</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="./welcome.jsp">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./alldata.jsp">Data</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./insert.jsp">Add</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./search.jsp">Search</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" onclick="logout()">LogOut</a>
      </li>
    </ul>
  </div>
</nav>
<div>
<marquee><h3>Welcome To CURD Operation</h3></marquee>
</div>
<script src=".\\JS\\userCheck.js"></script>
<script src=".\\JS\\logout.js"></script>
</body>
</html>