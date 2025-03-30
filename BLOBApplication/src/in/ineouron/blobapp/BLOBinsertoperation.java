package in.ineouron.blobapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class BLOBinsertoperation {

	public static void main(String[] args)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;

		FileInputStream fis = null;
		String insertQuery ="insert into persons(name, image) values(?,?)";
		String name = "Shimla";
		try
		{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(insertQuery);
				if(pstmt != null)
				{
					
				//	f = new File();
					fis = new FileInputStream("abc.jpg");
					
					pstmt.setString(1, name);
					pstmt.setBlob(2, fis);
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
