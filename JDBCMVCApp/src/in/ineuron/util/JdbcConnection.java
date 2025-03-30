package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcConnection 
{
	static Connection connection = null;
	private JdbcConnection()
	{
		
	}
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws IOException, SQLException
	{
		HikariConfig config = new HikariConfig("D:\\Java Programs Jan 22\\Advanced Java\\JDBCMVCApp\\src\\in\\ineuron\\properties\\db.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		Connection connection = dataSource.getConnection();
		return connection;
	}
	@SuppressWarnings("unused")
	private static Connection physicalConnection() throws IOException, SQLException
	{
		FileInputStream fis = new FileInputStream("src\\in\\ineuron\\properties\\db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
