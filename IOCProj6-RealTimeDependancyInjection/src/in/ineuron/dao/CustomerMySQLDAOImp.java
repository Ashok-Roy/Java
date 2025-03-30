package in.ineuron.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import in.ineuron.bo.CustomerBO;

public class CustomerMySQLDAOImp implements ICustomerDAO {

	private DataSource dataSource;

	static {
		System.out.println("CustomerMySQLDAOImpl.class file is loading...");
	}

	public CustomerMySQLDAOImp(DataSource dataSource) {
		System.out.println("CustomerMySQLDAOImp:: 1 param constructor...");
		this.dataSource = dataSource;
	}

	@Override
	public int insert(CustomerBO bo) {

		try (Connection connection = dataSource.getConnection()) {
			System.out.println("connection established succesfully....");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
