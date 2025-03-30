package in.ineouron.insertdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class InsertDateApp {
	public static void main(String[] args) throws ParseException
	{
		Scanner scan = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement pst = null;
		
		System.out.println("Enter your name:: ");
		String name = scan.next();
		
		// This two pattern should be same (dd-mm-yyyy)
		System.out.println("Enter your DOB (dd-mm-yyyy)::");
		String dob = scan.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		java.util.Date utilDate = sdf.parse(dob);
		long l = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(l);
		
		System.out.println("String date is : "+ dob);
		System.out.println("Util date is : "+ utilDate);
		System.out.println("SQL date is : "+ sqlDate);
		try{
			connection = JdbcConnectionUtil.getConnection();
			
			String query = "insert into employee(name, dob)values(?,?)";
			if(connection != null)
			{
				pst = connection.prepareStatement(query);
				if(pst != null){
					pst.setString(1, name);
					pst.setDate(2, sqlDate);
					
					int row = pst.executeUpdate();
					System.out.println("No of rows affected " + row);
				}
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try {
				JdbcConnectionUtil.closeResource(null, pst, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(scan != null)
				scan.close();
		}
	}
}
