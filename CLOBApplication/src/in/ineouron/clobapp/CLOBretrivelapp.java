package in.ineouron.clobapp;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class CLOBretrivelapp {

	public static void main(String[] args)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		File f = null;
		FileWriter writer = null;
		
		
		String selectQuery ="select history from citys where id = ?";
		int id = 1;
		try
		{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(selectQuery);
				if(pstmt != null)
				{
					pstmt.setInt(1, id);
					rs = pstmt.executeQuery();
					if(rs != null)
					{
						if(rs.next())
						{
							Reader reader = rs.getCharacterStream(1);
						
							
							f = new File("shimla.text");
							writer = new FileWriter(f);
						
							// Using 3rd party API
							IOUtils.copy(reader, writer);
							
							System.out.println(f.getAbsolutePath());
						}
						writer.flush();
					}
				}
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				JdbcConnectionUtil.closeResource(rs, pstmt, connection);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
		
		
	}

}
