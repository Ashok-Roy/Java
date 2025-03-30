package in.ineuron.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import in.ineuron.util.JdbcConnection;

public class TestApp {

	public static void main(String[] args) 
	{
		Connection connection = null;
		try {
			connection = JdbcConnection.getConnection();
			if(connection != null)
				System.out.println(connection.getClass().getName());
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}
