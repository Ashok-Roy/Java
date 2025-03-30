package in.ineouron.clobapp;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class CLOBinsertoperation {

	public static void main(String[] args)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		//File f =null;
		FileReader reader = null;
		String insertQuery ="insert into citys(name, history) values(?,?)";
		String name = "Shimla";
		try
		{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(insertQuery);
				if(pstmt != null)
				{
					
					//f = new File("history.text");
					reader = new FileReader("history.text");
					
					pstmt.setString(1, name);
					pstmt.setCharacterStream(2, reader);
					
					
					int row = pstmt.executeUpdate();
					System.out.println("No of row affected " + row);
				}
			}
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(IOException io){
			io.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				JdbcConnectionUtil.closeResource(null, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
