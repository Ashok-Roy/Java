<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
<link rel="stylesheet" href=".\\CSS\\style.css" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body bgcolor="lightgreen">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="http://localhost:8080/DynamicCURDApp/index.jsp">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="./insert.jsp">CREATE<span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="./searchbyid.jsp">READ</a>
      <a class="nav-item nav-link" href="./alldata">UPDATE</a>
      <a class="nav-item nav-link" href="./deletebyid.jsp">DELETE</a>
      <form action="./alldata" method="post">
     	 <a type="sub" class="nav-item nav-link" href="./alldata">ALL DATA</a>
      </form>
      <form class="form-inline" action="./LogOutServlet" method="post">
      		<%
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	
 				if(session.getAttribute("name") == null)
 				{
 					response.sendRedirect("./login.jsp");
 				}
 			%>
    		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">LOG OUT</button>

  	</form>      
    </div>
  </div>
</nav>

<div>
<marquee width="100%" direction="right" height="100px">
<h3 style="color: lightgreen;">WELCOME TO MY APPLICATION</h3>
</marquee>
</div>
</body>
</html>
