package datacollector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import loader.Loader;

public class CheckSubscription {

	public static int checkUser(String ani) {
		int status = 0;
		String uid="";
		try {
			int count = 0;
			String query = "select count(ani) as cnt from tbl_subscription where ani='" + ani
					+ "' and service_type='cashhub'";
			PreparedStatement ps = Loader.userconn.prepareStatement(query);
			System.out.println(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				count = rs.getInt(1);

			}
			if (count >= 1) {
					count = 0;
					query = "select count(1) as cnt from tbl_subscription where ani='" + ani
							+ "' and service_type='cashhub' " + "and date(next_billed_date)>=  Date(now())";
					PreparedStatement pst = Loader.userconn.prepareStatement(query);
					System.out.println(query);
					ResultSet rst = pst.executeQuery();
					if (rst.next()) {
						count = rst.getInt(1);
					}
					if (count >= 1) {
						status = 1;
						insertUserGame(ani);
					} else {
						status = 2;
					}
			} else {
				status = 0;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	private static void insertUserGame(String ani) {

		int status = checkUserInGames(ani);
		PreparedStatement st;
		try {
			if (status == 0) {

				String query = "insert into tbl_user (user_id,ticket)values('" + ani + "','1')";
				st = Loader.conn.prepareStatement(query);
				st.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static int checkUserInGames(String ani) {
		try {
			String query = "select count(1) from tbl_user where user_id='" + ani + "'";
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	
	public static String  getUserid(String ani) {
		try {
			String query = "select id from tbl_user where user_id='" + ani + "'";
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "0";
	}
	
	public static String  getUserAni(String id) {
		try {
			String query = "select id from tbl_user where user_id='" + id + "'";
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public static String checkUserInSubscription(String id) throws SQLException
	{
		
		String ani=getUserAni(id);
		if(ani.isEmpty()) return "0";
		String query = "select count(1) as cnt from tbl_subscription where ani='" + ani
				+ "' and service_type='cashhub' " + "and date(next_billed_date)>=  Date(now())";
		PreparedStatement pst = Loader.userconn.prepareStatement(query);
		System.out.println(query);
		ResultSet rst = pst.executeQuery();
		if (rst.next()) {
			
			return rst.getString(1);
		}
		
		return "0";
	}
	

}
