<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body style="background-color:green;">
	<div align='center'>
	<h1 style="color:white text-align= center">Welcome To LogIn</h1>
		<form action="./ValidationServlet" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" required="required"></td>				
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required"></td>				
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="LogIn"></td>				
				</tr>
			
			</table>
		</form>
	</div>
</body>
</html>