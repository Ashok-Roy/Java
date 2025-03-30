package in.ineouron.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class TransactionApplication {

	public static void main(String[] args)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		Scanner scan = null;
		
		String query = "select name, balance from Account";
		try{
			connection = JdbcConnectionUtil.getConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(query);
				if(pstmt != null)
				{
					rs = pstmt.executeQuery();
					if(rs!=null)
					{
						System.out.println("Data Before Transaction");
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
						}
					}
					System.out.println("-----------------");
					System.out.println("Transaction Start...");
					// disable the auto commit nature
					connection.setAutoCommit(false);
					pstmt.executeUpdate("update account set balance = balance-3000 where name ='sachin'");
					pstmt.executeUpdate("update account set balance = balance+3000 where name ='dhoni'");
					
					scan = new Scanner(System.in);
					System.out.println("Do you want to perform transaction of 3000, [YES/NO]");
					String option = scan.next();
					if(option.equalsIgnoreCase("yes"))
					{
						connection.commit();
						System.out.println("Transaction Commited...");
					}else{
						connection.rollback();
						System.out.println("Transaction Rollback");
					}
					
					System.out.println("Data After Transaction...");
					rs1 = pstmt.executeQuery();
					if(rs1!=null)
					{
						while(rs1.next())
						{
							System.out.println(rs1.getString(1)+"\t"+rs1.getInt(2));
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
				JdbcConnectionUtil.closeResources(rs, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
