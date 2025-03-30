package com.ineuron.jdbc.curd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOperation {
	public static void deleteOperation() throws SQLException
	{
		Scanner scan = null;
		
		Connection connection = ConnectionCreation.getConnection();
		Statement statement = null;
		try
		{
			if(connection != null)
			{
				statement = connection.createStatement();
				if(statement != null)
				{
					scan = new Scanner(System.in);
					System.out.println("Please enter the Student id for delete");
					int sid = scan.nextInt();
					
					String sql="delete from student where sid = "+sid;
					statement.executeUpdate(sql);
					System.out.println("Deletion succesful...");
				}
			}
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
			
		}
		
	}
}
