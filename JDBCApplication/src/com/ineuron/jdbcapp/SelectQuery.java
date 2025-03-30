package com.ineuron.jdbcapp;

// JDBC API
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// From third party
import com.mysql.cj.jdbc.Driver;

public class SelectQuery {

	public static void main(String[] args) throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		String url="jdbc:mysql://localhost:3306/newone";
		String user="root";
		String password ="root";
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection.getClass().getName());
		
		Statement st = connection.createStatement();
		System.out.println(st.getClass().getName());
		
		String sqlQuery ="select sid, sname, sage from student";
		ResultSet rs = st.executeQuery(sqlQuery);
		
		System.out.println("SID\tSNAME\tSAGE");
		System.out.println("+==========================+");
		while(rs.next())
		{
			int sid = rs.getInt(1);
			String sname = rs.getString(2);
			int sage = rs.getInt(3);
			
			System.out.println(sid+"\t"+sname+"\t"+sage);
		}
		
		rs.close();
		st.close();
		connection.close();
	}

}
