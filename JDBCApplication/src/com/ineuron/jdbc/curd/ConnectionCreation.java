package com.ineuron.jdbc.curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreation
{
	public static Connection getConnection()
	{
		Connection connection = null;
		String url ="jdbc:mysql://localhost:3306/newone";
		String user = "root";
		String password = "root";
		try{
			connection = DriverManager.getConnection(url,user,password);
			if(connection != null)
			{
				return connection;
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
}
