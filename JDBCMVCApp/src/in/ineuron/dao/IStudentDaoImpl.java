package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcConnection;

public class IStudentDaoImpl implements IStudentDao {
	Connection connection = null;
	String status = null;
	@Override
	public String save(Student student) 
	{
		PreparedStatement pstmt = null; 
		try 
		{
			String insertQuery = "insert into Student(name, email, city, country) values(?,?,?,?)";
			System.out.println(insertQuery);
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null)
				pstmt = connection.prepareStatement(insertQuery);
			if(pstmt != null)
			{
				pstmt.setString(1, student.getName());
				pstmt.setString(2, student.getEmail());
				pstmt.setString(3, student.getCity());
				pstmt.setString(4, student.getCountry());
				
			}
			if(pstmt != null)
			{
				int rowCount = pstmt.executeUpdate();
				if(rowCount == 1)
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
	public Student findById(Integer sid) {
		PreparedStatement pstmt = null; 
		Student student = null;
		try 
		{
			String selectQuery = "select id, name, email, city, country from Student where id =?";
			
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null)
				pstmt = connection.prepareStatement(selectQuery);
			if(pstmt != null)
			{
				pstmt.setInt(1, sid);
			}
			if(pstmt != null)
			{
				ResultSet resultSet = pstmt.executeQuery();
				if(resultSet.next())
				{
					//copy the resultSet data to StudentDto and transfer to the view
					student = new Student();
					student.setSid(resultSet.getInt(1));
					student.setName(resultSet.getString(2));
					student.setEmail(resultSet.getString(3));
					student.setCity(resultSet.getString(4));
					student.setCountry(resultSet.getString(5));
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();	
		}
		return student;
	}

	@Override
	public String updateById(Student student)
	{
		
		PreparedStatement pstmt = null; 
		try 
		{
			String updateQuery = "update student set name=?, email=?, city=?, country=? where id=?";
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null)
				pstmt = connection.prepareStatement(updateQuery);
			if(pstmt != null)
			{
				pstmt.setString(1, student.getName());
				pstmt.setString(2, student.getEmail());
				pstmt.setString(3, student.getCity());
				pstmt.setString(4, student.getCountry());
				pstmt.setInt(5, student.getSid());
				
			}
			if(pstmt != null)
			{
				int rowCount = pstmt.executeUpdate();
				if(rowCount == 1)
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
	public String deleteById(Integer sid) 
	{
			PreparedStatement pstmt = null; 
			String deleteQuery = "delete from student where id = ?";
			try 
			{
				Student student = findById(sid);
				if(student != null)
				{
					connection = JdbcConnection.getJdbcConnection();
					if(connection != null)
						pstmt = connection.prepareStatement(deleteQuery);
					if(pstmt != null)
					{
						pstmt.setInt(1, sid);
						
					}
					if(pstmt != null)
					{
						int rowCount = pstmt.executeUpdate();
						if(rowCount == 1)
							status = "success";
					}
				}else{
					status="failure";
				}
			} catch (IOException | SQLException e) {
				e.printStackTrace();
				status = "failure";
			}
			return status;
	}

}
