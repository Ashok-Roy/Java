package in.ineouron.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionUtil {
	private JdbcConnectionUtil()
	{
		
	}
	public static Connection getConnection()
	{
		Connection connection = null;
		String url ="jdbc:mysql://localhost:3306/newone";
		String user = "root";
		String password = "root";
		try{
			connection = DriverManager.getConnection(url, user, password);
			if(connection != null)
				return connection;
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeResources(ResultSet resultSet, Statement statement, Connection connection) throws SQLException
	{
		if(resultSet != null)
			resultSet.close();
		if(statement != null)
			statement.close();
		if(connection != null)
			connection.close();
	}
}
