<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    	
</head>
<body >
<div align="center">
<br>
<br>
<br>
	<button class="btn btn-primary" id="showDataButton" onclick="getData();">Employee Data</button>

<div style="border:1px solid black; padding:3px; width:1200px;">
	<table id="myTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Email</th>
                <th>City</th>
            </tr>
        </thead> 
        <tbody id="tbody">
        
        </tbody>
	</table>
</div>
</div>

	<script src=".\\JS\\allemployeedata.js"></script>
<!-- Boostrap jQuery datatables library -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script> 
 	<script type="text/javascript" src= "https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap4.min.js"></script>

	
</body>
</html>
