package in.ineouron.dynamicinput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class InsertApp {
	public static void main(String[] args) 
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name :");
		String name = scanner.next();
		System.out.print("Enter your age :");
		int age = scanner.nextInt();
		String sqlInsertQuery = "insert into student(sname, sage) values(?,?)";
		try{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(sqlInsertQuery);
				if(pstmt != null)
				{
					pstmt.setString(1, name);
					pstmt.setInt(2, age);
					
					int row = pstmt.executeUpdate();
					System.out.println("No of row affected : " + row);
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
			if(scanner != null)
				scanner.close();
		}
		
	}

}
