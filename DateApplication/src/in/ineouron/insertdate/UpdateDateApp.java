package in.ineouron.insertdate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class UpdateDateApp {

	public static void main(String[] args) throws ParseException
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		//System.out.println("Enter DOB (dd-MM-yyyy): : ");
		//String dob = scan.next();
		
	//	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//java.sql.Date utilDate = (Date) sdf.parse(dob);
		//long l = utilDate.getTime();
		//java.sql.Date sDate = new java.sql.Date(l);
		Date newDate = new Date(System.currentTimeMillis()); // current date
		Integer id = 1;
		String sql = "update employee set dob = ? where id =?";
		try
		{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(sql);
				if(pstmt != null)
				{
					pstmt.setInt(1, id);
					pstmt.setDate(2, newDate);
					int row = pstmt.executeUpdate();
					System.out.println("No of row affected "+ row);
				}
				
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				JdbcConnectionUtil.closeResource(null, pstmt, connection);
				if(scan!=null)
					scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
