package in.ineuron.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcConnection
{
	private static Connection connection = null;
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	private JdbcConnection()
	{
		
	}
	@SuppressWarnings("resource")
	public static Connection getConnection() throws IOException, SQLException
	{
		
		String path="D:\\Java Programs Jan 22\\Advanced Java\\CURD-MVC-JS-JSON-01\\src\\in\\ineuron\\properties\\db.properties";
		
		HikariConfig config = new HikariConfig(path);
		HikariDataSource dataSource = new HikariDataSource(config);
		connection = dataSource.getConnection();
		
//		FileInputStream fis = new FileInputStream(path);
//		Properties properties = new Properties();
//		properties.load(fis);
//		String url = properties.getProperty("url");
//		String user = properties.getProperty("user");
//		String password = properties.getProperty("password");
//		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException
	{
		if(connection != null)
			connection.close();
		if(preparedStatement != null)
			preparedStatement.close();
		if(resultSet != null)
			resultSet.close();
		
	}
}
