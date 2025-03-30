package in.ineouron.dynamicinput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class SelectApp {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		System.out.print("Enter the sid : ");
		int sid = scan.nextInt();
		String selectQuery = "select sid, sname, sage from student where sid = ?";
		try{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(selectQuery);
				if(pstmt != null)
				{
					pstmt.setInt(1, sid);
					rs = pstmt.executeQuery();
					if(rs != null)
					{
						
						// We are getting only 1 or 0 result at a time 
						// so use if...else
						if(rs.next())
						{
							System.out.println("SID\tSNAME\tSAGE");
							
							// why waste 3 variables 
//							int id = rs.getInt(1);
//							String sname = rs.getString(2);
//							int sage = rs.getInt(3);
//							System.out.println(id +"\t" + sname+"\t"+sage);
							
							
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
						}else{
							System.out.println("Result Not Found..!");
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
			if(scan != null)
				scan.close();
		}

	}

}
