package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	static Connection con = null;

	public static Connection getDbConn() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/newtwo",
					"root", "root");
		/*	con = DriverManager.getConnection("jdbc:mysql://91.205.172.123:3306/cashhub_ndoto?autoReconnect=true",
					"root", "gloadmin123"); */
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/winhubsts?autoReconnect=true","root","gloadmin123");

			System.out.println("Cashhub Db is Conneted");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return con;
	}
	
	
	

	public static Connection getUserDbConn() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://91.205.172.123:3306/ndotosts?autoReconnect=true",
					"root", "gloadmin123");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ndotosts?autoReconnect=true","root","gloadmin123");

			System.out.println("WinHubUser Db is Conneted");

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return con;
	}

}
