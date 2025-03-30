package com.ineuron.jdbc.curd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOperation
{
	public static void insertOperation() throws SQLException
	{
		Scanner scan = null; 
		Connection connection = ConnectionCreation.getConnection();
		Statement statement = null;
		try{
			if(connection != null)
			{
				statement = connection.createStatement();
				if(statement != null)
				{
					scan = new Scanner(System.in);
					System.out.println("Enter name to insert :");
					String name = scan.nextLine();
					System.out.println("Enter age to inser   :");
					int age = scan.nextInt();
					String sql =String.format("insert into student(sname, sage) values('%s',%d)", name,age);
					
					statement.executeUpdate(sql);
					System.out.println("========Insertion succesful========");
				}
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
			
			
		}
		
		
	}
}
