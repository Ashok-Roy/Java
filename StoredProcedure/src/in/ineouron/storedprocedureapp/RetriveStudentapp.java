package in.ineouron.storedprocedureapp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

/*
 *DELIMITER $$
CREATE
    PROCEDURE `newone`.`getStudentByID`(IN id INT, OUT stdName varchar(20), stdAge int)
	BEGIN
		SELECT sname, sage
		FROM student
		WHERE sid = id;
	END$$
DELIMITER ;
call getStudentByID(101, @stdName, @stdAge);
select @stdName AS 'name';
select @stdName AS 'age';

 */

public class RetriveStudentapp {
	public static void main(String[] args) 
	{
		Connection connection = null;
		CallableStatement cstmt = null;
	
		String query = "{CALL getStudentByID(?, ?, ?)}";

		Integer id = 101;
		try{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				cstmt = connection.prepareCall(query);
				if(cstmt != null)
				{
					cstmt.setInt(1, id);
					
					cstmt.registerOutParameter(2,Types.VARCHAR);
					cstmt.registerOutParameter(3, Types.INTEGER);
					
					cstmt.execute();
				
					System.out.println("Student name is :" +cstmt.getString(2));
					System.out.println("Student age is :" +cstmt.getInt(3));
					
				}
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try {
				JdbcConnectionUtil.closeResources(null, cstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
