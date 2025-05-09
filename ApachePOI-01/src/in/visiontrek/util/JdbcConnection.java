package in.visiontrek.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection
{
	private static Connection connection = null;
	private JdbcConnection()
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
		FileInputStream fis = new FileInputStream("src\\in\\visiontrek\\properties\\db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
		return connection;
	}


}
