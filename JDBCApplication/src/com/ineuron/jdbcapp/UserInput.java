package com.ineuron.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) throws SQLException
	{
		Scanner scanner = new Scanner(System.in);
		Connection connection = null;
		Statement statement = null;
	
		String url="jdbc:mysql://localhost:3306/newone";
		String user = "root";
		String password = "root";
		try{
			System.out.println("Enter your name : ");
			String name = scanner.nextLine();
			System.out.println("Enter your age : ");
			int age = scanner.nextInt();
			connection = DriverManager.getConnection(url, user, password);
			
			if(connection != null)
			{
			//	String sql = "insert into student(sname, sage)"
			//						+ " values('"+ name+"',"+ age+");";
				
				String sql = String.format("insert into student(sname, sage) values('%s',%d)",name, age);
				System.out.println(sql);		
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
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			if(statement != null)
				statement.close();
			if(connection != null)
				statement.close();
			scanner.close();
		}
		

	}

}
