package in.ineouron.connectionpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class ConnectionPoolApp {
	public static void main(String[] args) throws SQLException {
		MysqlConnectionPoolDataSource datasource = new MysqlConnectionPoolDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/newone");
		datasource.setUser("root");
		datasource.setPassword("root");
		
		Connection connection = datasource.getConnection();
		Statement st = connection.createStatement();
		String query = "select * from student";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
		}
		connection.close();
	}
}
