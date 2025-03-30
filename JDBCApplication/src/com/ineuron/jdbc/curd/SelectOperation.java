package com.ineuron.jdbc.curd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectOperation {
	public static void selectOperation() throws SQLException
	{
		Connection connection = ConnectionCreation.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			if(connection != null)
			{
				statement = connection.createStatement();
				if(statement != null)
				{
					String sql = "select * from student;";
					resultSet = statement.executeQuery(sql);
					if(resultSet != null)
					{
						System.out.println("SID\tSNAME\tSAGE");
						System.out.println("============================");
						while(resultSet.next())
						{
							int sid = resultSet.getInt(1);
							String sname = resultSet.getString(2);
							int sage = resultSet.getInt(3);
							System.out.println(sid+"\t"+sname+"\t"+sage);
						}
						System.out.println("============================");
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
