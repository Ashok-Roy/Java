<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgreen">
	<div align='center'>
	<h1>Hey <%= request.getParameter("name") %> You Are Already Exist</h1>
		<table>
			<tr>
				<td><a = href="./index.html"><input type="button" value="Back"></a></td>
			</tr>
		</table>
	

	
	</div>
	
</body>
</html>