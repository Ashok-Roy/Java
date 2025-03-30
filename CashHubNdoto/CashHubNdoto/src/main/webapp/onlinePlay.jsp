<%@page import="datacollector.DataCollector"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Play</title>
</head>
<style>
	  iframe{ 
	  width:100%; 
	  height:100vh; 
	  margin: 0;
	  padding: 0;
	  display: block;
	  scroll:hidden;
/* 	  border:0; */
	  } 
	  body{
	  margin: 0;
	  padding: 0;
	  display: block;
	  
	  
	  }
	  </style>
	  <%
	  String gameid=request.getParameter("gameid");
//       String date=  DataCollector.getDemoUserDetails("9888495960");
      
    
// 		          date= date.substring(0, 10).trim();
// 		           System.out.println(gameid+"Date of at The Time "+date);
			 	 String url=request.getParameter("url"); 
// 		      	 LocalDate lo=LocalDate.parse(date);
//                 int i=lo.compareTo(LocalDate.now());
//                 System.out.println("Date of at The Time "+i);
//                 if(i == 0){
//                 }
               
               %>
	  
<body>


    	<iframe seamless src="<%=url+"&gameid="+gameid%>" allowTransparency="true" scrolling="no" frameborder="0"  ></iframe>

</body>
</html>