package in.ineouron.jdbcutil;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConnectionUtil {
	private JdbcConnectionUtil()
	{
		
	}
	public static Connection getConnection()
	{
		Connection connection = null;
		FileInputStream fis = null;
		Properties props = null;
		
		try{
			fis = new FileInputStream("D:\\Java Programs Jan 22\\Advanced Java\\TransactionInJDBC\\src\\in\\ineuron\\propertiesfile\\jdbc.properties");
			props = new Properties();
			props.load(fis);
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String password = props.getProperty("password");
	
			
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
