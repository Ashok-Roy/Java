package com.ineuron.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExampleOne {
	public static void main(String[] args) throws SQLException
	{
		//Step 1: load and register the driver
		//Driver driver = new Driver();
		//DriverManager.registerDriver(driver);
		
		//Step2: Establish the connection b/w java and Database
		
		// JDBC URL SYNTAX:: <mainprotocol>:<subprotocol>:<subname>
		String url ="jdbc:mysql://localhost:3306/newone";
		String user="root";
		String password="root";
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//Step 3: Creation of a statement object to move to the location using connection
		Statement statement = connection.createStatement();
		
		// Step 4: Using statement Object execute the query
		String selQuery="select * from student";
		
		
		// Step 5: Process the result set to get the data
		ResultSet rs = statement.executeQuery(selQuery);
		
		System.out.println("SID\tSNAME\tSAGE");
		while(rs.next())
		{
			int sid = rs.getInt("sid");
			String sname = rs.getString("sname");
			int sage = rs.getInt("sage");
			System.out.println(sid+"\t"+sname+"\t"+sage);
		}
		
		
		// Step 6: close the resources 
		rs.close();
		statement.close();
		connection.close();
		
	}

}
