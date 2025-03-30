package in.ineouron.storedprocedureapp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

/*
 DELIMITER $$
CREATE
    PROCEDURE `newone`.`getStudent`(id INT)
	BEGIN
		SELECT sid, sname, sage
		FROM student
		WHERE sid = id;
	END$$
DELIMITER ;
call getStudent(101);
 */
public class RetriveStudentDataApp {

	public static void main(String[] args) 
	{
		Connection connection = null;
		CallableStatement cstmt = null;
		ResultSet resultSet = null;
		// Syntax for stored Procedure
		String query = "{ CALL getStudent(?)} ";
	
		int id = 101;
		try{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				cstmt = connection.prepareCall(query);
				if(cstmt != null)
				{
					cstmt.setInt(1, id);
					cstmt.execute();
					resultSet = cstmt.getResultSet();
					if(resultSet !=null)
					{
						if(resultSet.next())
						{
							System.out.println("SID\tSNAME\tSAGE");
							System.out.println(resultSet.getInt(1)+
									"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3));
							
						}else{
							System.out.println("Result Not Found");
						}
					}
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
				JdbcConnectionUtil.closeResources(resultSet, cstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
