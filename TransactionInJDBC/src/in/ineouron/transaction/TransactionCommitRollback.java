package in.ineouron.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import in.ineouron.jdbcutil.JdbcConnectionUtil;

public class TransactionCommitRollback {

	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		try{
			connection = JdbcConnectionUtil.getConnection();
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			statement.executeUpdate("insert into politician values('modi','bjp')");
			statement.executeUpdate("insert into politician values('stalin','dmk')");
			statement.executeUpdate("insert into politician values('momota','tml')");
			
			Savepoint sp = connection.setSavepoint();
			// rollback only for this query 
			statement.executeUpdate("insert into politician values('rahul','bjp')");
			System.out.println("OOPs! Something went wrong..");
			connection.rollback(sp);
			
			
			// commit for upper 3 query
			connection.commit();
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				JdbcConnectionUtil.closeResources(null, statement, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
