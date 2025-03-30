package com.ineuron.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQueryExample {

	public static void main(String[] args) throws SQLException 
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String url = "jdbc:mysql://localhost:3306/newone";
		String uname = "root";
		String password = "root";
		try{
			connection = DriverManager.getConnection(url,uname,password);
			if(connection != null)
			{
				statement = connection.createStatement();
				if(statement != null)
				{
					String sqlQuery = "select sid, sname, sage from student";
					resultSet = statement.executeQuery(sqlQuery);
					if(resultSet != null)
					{
						System.out.println("SID\tSNAME\tSAGE");
						while(resultSet.next())
						{
							int sid = resultSet.getInt("sid");
							String sname = resultSet.getString("sname");
							int sage = resultSet.getInt("sage");
							System.out.println(sid+"\t"+ sname+"\t"+sage);
						}
					}
				}
			}
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			if(resultSet != null)
				resultSet.close();
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
		}
		
		
		
		

	}

}
