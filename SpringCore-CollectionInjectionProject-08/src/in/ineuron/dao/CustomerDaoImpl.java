package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;


import in.ineuron.bo.CustomerBO;

public class CustomerDaoImpl implements ICustomerDao 
{
	private static final String CUSTOMER_INSERT_QUERY ="insert into customer(name, address, pri_amount, rate)"
			+ "values(?,?,?,?)";	
	private DataSource dataSource;
	
	// Constructor Injection
	private  CustomerDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
			
	@Override
	public int insert(CustomerBO bo)
	{
		
	
		System.out.println(bo);
		int row = 0;
		try(Connection connection = dataSource.getConnection())
		{
			
			PreparedStatement pstmt =  connection.prepareStatement(CUSTOMER_INSERT_QUERY);
			pstmt.setString(1, bo.getCustomerName());
			pstmt.setString(2, bo.getCustomerAddress());
			pstmt.setFloat(3, bo.getPamt());
			pstmt.setFloat(4, bo.getRate());
			
			row = pstmt.executeUpdate();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return row;
	}

}
