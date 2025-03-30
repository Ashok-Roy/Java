package com.ineuron.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQueryStd {

	public static void main(String[] args) throws SQLException 
	{
		Connection connection = null;
		Statement statement = null;
		String url = "jdbc:mysql://localhost:3306/newone";
		String user = "root";
		String password = "root";
		
		try{
			connection = DriverManager.getConnection(url, user, password);
			if(connection != null)
			{
				statement = connection.createStatement();
				String sqlQuery = "insert into student(sname, sage)values('Messi', 45)";
				if(statement != null)
				{
					int rows = statement.executeUpdate(sqlQuery);
					System.out.println("Row affected :"+ rows);
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
