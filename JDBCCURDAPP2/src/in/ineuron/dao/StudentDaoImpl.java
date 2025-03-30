package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao
{
	Connection connection = null;
	Statement stmt = null;
	String status ="";
	int row=0;
	@Override
	public String save(Student student)
	{
		String insertQuery=String.format("insert into student(name, email, city, country)values('%s','%s','%s','%s')", student.getName(),student.getEmail(),student.getCity(),student.getCountry());
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
				stmt = connection.createStatement();
			if(stmt != null)
			{
				row = stmt.executeUpdate(insertQuery);
				if(row == 1)
				{
					status = "success";
				}else{
					status = "failure";
				}
				
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student findById(Integer id) {
		String selectQuery ="select id,name,email,city,country from student where id ="+ id;
		Student student = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
				stmt = connection.createStatement();
			if(stmt != null)
			{
				ResultSet rs = stmt.executeQuery(selectQuery);
				if(rs != null)
				{
					if(rs.next())
					{
						student = new Student();
						student.setId(rs.getInt(1));
						student.setName(rs.getString(2));
						student.setEmail(rs.getString(3));
						student.setCity(rs.getString(4));
						student.setCountry(rs.getString(5));
					}
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateById(Student student) {
		
		return null;
	}

	@Override
	public String deleteById(Integer id) {
		String deleteQuery="delete from student where id ="+ id;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
				stmt = connection.createStatement();
			if(stmt != null){
				row = stmt.executeUpdate(deleteQuery);
				if(row ==1)
					status="success";
				else
					status="failure";
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

}
