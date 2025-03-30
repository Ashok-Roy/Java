package in.visiontech.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.visiontech.dto.Employee;
import in.visiontech.util.JdbcUtil;

public class EmployeeDaoImpl implements IEmployeeDao {
	Connection connection = null;
	int row=0;
	String status ="";
	@Override
	public String save(Employee employee) 
	{
		PreparedStatement pstmt = null;
		String insertQuery = "insert into employee(name, email, city) values(?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
				pstmt = connection.prepareStatement(insertQuery);
			if(pstmt != null)
			{
				pstmt.setString(1, employee.getEname());
				pstmt.setString(2, employee.getEmail());
				pstmt.setString(3, employee.getCity());
			}
			if(pstmt != null)
				row = pstmt.executeUpdate();
			if(row == 1)
				status="success";
			else
				status ="fail";
			
			} catch (IOException | SQLException e) {
			e.printStackTrace();
			status="fail";
		}
		return status;
	}

	@Override
	public Employee findById(Integer eid) {
		PreparedStatement pstmt = null;
		Employee employee = null;

		String selectQuery = "select id, name, email, city from employee where id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
				pstmt = connection.prepareStatement(selectQuery);
			if(pstmt != null)
			{
				pstmt.setInt(1, eid);
				
			}
			if(pstmt != null)
			{
				
				ResultSet resultSet = pstmt.executeQuery();
				if(resultSet.next())
				{
					employee = new Employee();
					employee.setEid(resultSet.getInt(1));
					employee.setEname(resultSet.getString(2));
					employee.setEmail(resultSet.getString(3));
					employee.setCity(resultSet.getString(4));
				}
			}
				
			} catch (IOException | SQLException e) {
			e.printStackTrace();
			
		}
		return employee;
	}

	@Override
	public String updateById(Employee employee)
	{
		PreparedStatement pstmt = null; 
		try 
		{
			String updateQuery = "update employee set name=?, email=?, city=? where id=?";
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
				pstmt = connection.prepareStatement(updateQuery);
			if(pstmt != null)
			{
				pstmt.setString(1, employee.getEname());
				pstmt.setString(2, employee.getEmail());
				pstmt.setString(3, employee.getCity());
				pstmt.setInt(4, employee.getEid());
				
			}
			if(pstmt != null)
			{
				row = pstmt.executeUpdate();
				if(row == 1)
				{
					status = "success";
				}else
					status = "failure";
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
		
	}

	@Override
	public String deleteById(Integer eid) {
		PreparedStatement pstmt = null;
		String deleteQuery = "delete from employee where id =?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
				pstmt = connection.prepareStatement(deleteQuery);
			if(pstmt != null)
			{
				pstmt.setInt(1, eid);
				
			}
			if(pstmt != null)
				row = pstmt.executeUpdate();
			if(row == 1)
				status="success";
			else
				status ="fail";
			
			} catch (IOException | SQLException e) {
			e.printStackTrace();
			status="fail";
		}
		return status;
	}

}
