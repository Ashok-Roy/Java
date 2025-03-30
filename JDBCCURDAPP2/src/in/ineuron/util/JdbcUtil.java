package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil 
{
	private static Connection connection = null;
	private JdbcUtil()
	{
		
	}
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static Connection getJdbcConnection() throws IOException, SQLException
	{
		FileInputStream fis = new FileInputStream("src\\in\\ineuron\\properties\\jdbc.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

}
