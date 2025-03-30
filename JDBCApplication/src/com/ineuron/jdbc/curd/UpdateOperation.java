package com.ineuron.jdbc.curd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateOperation {
	public static void updateOperation() throws SQLException
	{
		Scanner scanner = null;
		
		Connection connection = ConnectionCreation.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			if(connection != null)
			{
				statement = connection.createStatement();
				if(statement != null)
				{
					scanner = new Scanner(System.in);
					System.out.print("Enter your student Id :");
					int sid = scanner.nextInt();
					System.out.println();
					System.out.println("Select what you want to update: ");
					System.out.print("For name update press 1");
					System.out.println();
					System.out.print("For age update press 2");
					String sql ="";
					int choice = scanner.nextInt();
					switch(choice)
					{
						case 1:
							System.out.print("Enter your name :");
							String name = scanner.next();
							sql = "update student set sname='"+name+"' where sid ="+sid;
							statement.executeUpdate(sql);
							System.out.println("Update succesful ");
							break;
						case 2:
							System.out.print("Enter your age :");
							int age = scanner.nextInt();
							sql = "update student set sage ="+age+" where sid ="+sid;
						
							statement.executeUpdate(sql);
							System.out.println("Update succesful ");
							break;
						default:
							System.out.println("Please choose the right options!");
							break;	
					}
				}
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e){
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
