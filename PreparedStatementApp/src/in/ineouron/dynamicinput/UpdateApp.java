package in.ineouron.dynamicinput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class UpdateApp {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		System.out.println("Enter student Id: ");
		int id = scan.nextInt();
		System.out.println("Enter age to update : ");
		int age = scan.nextInt();
		
		String sql = "update student set sage = ? where sid = ?";
		try{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(sql);
				if(pstmt != null)
				{
					pstmt.setInt(1, age);
					pstmt.setInt(2, id);
					int row = pstmt.executeUpdate();
					System.out.println("No of row affected :"+ row);
					
				}
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				JdbcConnectionUtil.closeResource(null, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(scan != null)
				scan.close();
		}
	}
}
