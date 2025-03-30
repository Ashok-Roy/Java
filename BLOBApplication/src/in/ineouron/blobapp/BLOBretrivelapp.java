package in.ineouron.blobapp;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class BLOBretrivelapp {

	public static void main(String[] args)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		//File f = null;
		InputStream is = null;
		FileOutputStream fos = null;
		
		
		String selectQuery ="select image from persons where id = ?";
		int id = 4;
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
							is  = rs.getBinaryStream(1);
							//int i = is.read();
							
							//f = new File("abc_download.jpg");
							fos = new FileOutputStream("abc_download.jpg");
							
							// Approach 3
							// Using 3rd party API
							IOUtils.copy(is, fos);
							fos.flush();
							
							
							
							// Approach 1
//							while(i != -1)
//							{
//								fos.write(i);
//								i = is.read();
//							}
//							
							// Approach 2
//							byte[] b = new byte[2048];
//							while(is.read(b) >0)
//							{
//								fos.write(b);
//							}
//							
							
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
				JdbcConnectionUtil.closeResource(rs, pstmt, connection);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
}
