<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Process</title>
</head>
<body>
<%!
	String name;
	Integer age;
	String address;
	
	static Connection connection = null;
	static Statement stmt = null;
	ResultSet rs = null;
	
	static{
		String url="jdbc:mysql://localhost:3306/newtwo";
		String user = "root";
		String password = "root";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			
			if(connection != null)
				stmt = connection.createStatement();
		}catch(ClassNotFoundException c)
		{
			c.printStackTrace();
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
%>
<%
	name = request.getParameter("name");
	age = Integer.parseInt(request.getParameter("age"));
	address = request.getParameter("address");
	System.out.println(name+" " +age + " " +address);
	rs = stmt.executeQuery("select name from student where name ='"+name+"'");
	
	boolean b = rs.next();
	if(b == true)
	{
%>
		<jsp:forward page="./userexist.jsp"></jsp:forward>
<% 
	}else
	{
		String insertQuery = String.format("insert into student(name, age, address)values('%s',%d, '%s')", name, age, address);
		int row = stmt.executeUpdate(insertQuery);
		if(row == 1)
		{
%>
			<jsp:forward page="./successful.jsp"></jsp:forward>
<%
		}else
		{
%>
			<jsp:forward page="./error.jsp"></jsp:forward>
<%
		}
	}
%>
</body>
</html>