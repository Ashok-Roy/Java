package in.ineouron.dateinsertapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class InsertMultipleDateApp {

	public static void main(String[] args) throws ParseException 
	{
		Scanner scan = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		
		System.out.print("Enter name ::");
		String name = scan.next();
		System.out.print("Enter DOB (dd-MM-yyyy) ::");
		String dob = scan.next();
		System.out.print("Enter DOJ (MM-dd-yyyy) ::");
		String doj = scan.next();
		System.out.print("Enter DOM (yyyy-MM-dd) ::");
		String dom = scan.next();
		
		String insertQuery = "insert into users(name, dob, doj, dom)values(?,?,?,?)";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date uDate1 = sdf1.parse(dob);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date uDate2 = sdf2.parse(doj);
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date uDate3 = sdf3.parse(dom);
	
		
		long l1 = uDate1.getTime();
		long l2 = uDate2.getTime();
		long l3 = uDate3.getTime();
		
		
		java.sql.Date sDate1 = new java.sql.Date(l1);
		java.sql.Date sDate2 = new java.sql.Date(l2);
		java.sql.Date sDate3 = new java.sql.Date(l3);
	
		
		try{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(insertQuery);
				if(pstmt != null)
				{
					pstmt.setString(1, name);
					pstmt.setDate(2, sDate1);
					pstmt.setDate(3, sDate2);
					pstmt.setDate(4, sDate3);
					
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(scan != null)
				scan.close();
		}
		
	}

}
