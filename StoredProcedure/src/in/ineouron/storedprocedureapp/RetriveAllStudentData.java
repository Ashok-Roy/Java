package in.ineouron.storedprocedureapp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class RetriveAllStudentData {

	public static void main(String[] args)
	{
		Connection connection = null;
		CallableStatement cstmt = null;
		ResultSet resultSet = null;
		
		String query = "{call getStudentAll()}";
		
		try{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				cstmt = connection.prepareCall(query);
				if(cstmt != null)
				{
					cstmt.execute();
					resultSet = cstmt.getResultSet();
					if(resultSet != null)
					{
						System.out.println("SID\tSNAME\tSAGE");
						while(resultSet.next())
						{
							System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"
									+resultSet.getInt(3));
				
						}
					}
					
				}
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
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
