package com.ineuron.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery {

	public static void main(String[] args) throws SQLException 
	{
		Connection connection = null;
		Statement statement = null;
		String url ="jdbc:mysql://localhost:3306/newone";
		String user = "root";
		String password = "root";
		try{
			connection = DriverManager.getConnection(url, user, password);
			if(connection != null)
			{
				String sql = "update student set sid = 103 where sid = 1013";
				statement = connection.createStatement();
				if(statement != null)
				{
					int row = statement.executeUpdate(sql);
					System.out.println("Rows affected : " + row);
				}
			}
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
		}
		
	}

}
