package in.ineouron.insertdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class SelectDateApp {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.print("Enter name :: ");
		String name = scan.next();
		
		String selectQuery = "select id, name, dob from employee where name = ?";
		try{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(selectQuery);
				if(pstmt != null)
				{
					pstmt.setString(1, name);
					rs = pstmt.executeQuery();
					if(rs != null){
						if(rs.next())
						{
							int id = rs.getInt(1);
							String ename = rs.getString(2);
							// Getting date as sql nature date 
							java.sql.Date sqlDate = rs.getDate(3);
							System.out.println(sqlDate);
							// Converting sql date to String format
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							String dob = sdf.format(sqlDate);
							
							System.out.println(id+"\t"+ename+"\t"+dob);
						}else{
							System.out.println("Result Not Found...");
						}
					}
				}
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
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
