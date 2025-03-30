<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style='background-color:green'>
	<div align='center'>
		<table>
			<tr>
				<td><h1>Hey <%= request.getAttribute("name") %> Congratulation </h1></td>
			</tr>
			<tr>
				<td><h1>Log In Successful</h1></td>
			</tr>
			
		</table>
	</div>

</body>
</html>