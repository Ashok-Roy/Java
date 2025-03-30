package datacollector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import Model.Parameters;
import loader.Loader;

public class DataCollector {

	public static ResultSet getGames() {

		String query = "select * from tbl_game where status in('0') ";
		System.out.println(query);
		ResultSet rs = null;
		try {
			Statement st = Loader.conn.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static Map<String, String> getParticularGame(String id) {

		Map<String, String> map = new HashMap<>();
		String query = "select * from tbl_game where game_id='" + id + "'";
		System.out.println(query);
		try {
			Statement st = Loader.conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				map.put("imgurl", rs.getString("game_img"));
				map.put("name", rs.getString("game_name"));
				map.put("link", rs.getString("game_link"));
				map.put("about", rs.getString("game_about"));
				map.put("gameprize", rs.getString("game_prize"));
				map.put("gamedesc", rs.getString("game_desc"));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return map;
	}

	public static ResultSet getGameRewards() {

		String query = "select * from tbl_Rewards";
		System.out.println(query);
		try {

			Statement st = Loader.conn.createStatement();
			return st.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	public static long getpoints(String userid) {

		String query = "select * from tbl_user where user_id='" + userid + "'";
		System.out.println(query);
		long points = 0;
		try {
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				points = Long.parseLong(rs.getString("user_points"));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return points;
	}

	public static void updateUserPoints(Parameters param, long points) {

		String query = "update tbl_user set user_points='" + points + "' where user_id='" + param.getUserid() + "'";

		System.out.println(query);
		try {
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertRedeemPoints(Parameters param) {

		String query = "insert into tbl_point_ded_history (user_id,point_deduct,type)values('" + param.getUserid()
				+ "','" + param.getPoints() + "','" + param.getType() + "')";

		System.out.println(query);
		try {
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void enterPoints(Parameters param) {

		String query = "insert into tbl_point_win set user_id='" + param.getUserid() + "',point_win='"
				+ param.getPoints() + "',game_id='" + param.getGameid() + "'";

		System.out.println(query);

		try {
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int insertUserTicket(Parameters param) {
		int totalticket = 0;
		try {

			String query = "insert into tbl_user_buyticket (user_id,ticket_buy) values('" + param.getUserid() + "','"
					+ param.getTicket() + "')";
			System.out.println(query);
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ps.executeUpdate();

			totalticket = Integer.parseInt(param.getTicket()) + getUserTotalTicket(param);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalticket;
	}

	public static int getUserTotalTicket(Parameters param) {
		int ticket = 0;
		int count = 0;
		int id = 0;

		try {

			String query = "select ticket,count(1) from tbl_user where id='" + param.getUserid() + "'";
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			System.out.println(query);

			if (rs.next()) {
				ticket = rs.getInt(1);
				count = rs.getInt(2);
			}
//			if(count==0)
//			{
//				
//				query ="insert into tbl_totalticket (user_id) values('"+param.getUserid()+"')";
//				PreparedStatement pst=Loader.conn.prepareStatement(query);
//				pst.execute();
//			System.out.println(query);
//			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return ticket;
	}

	public static int checkUser(Parameters param) {

		int count = 0;
		try {

			String query = "select count(1) from tbl_user where user_id='" + param.getUserid() + "'";
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				count = rs.getInt(1);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return count;
	}

	public static void updateUserTicket(Parameters param, long totalticket) {

		try {

			String query = "update  tbl_user set ticket='" + totalticket + "' where user_id='" + param.getUserid()
					+ "'";
			PreparedStatement pst = Loader.conn.prepareStatement(query);
			pst.executeUpdate();
			System.out.println(query);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static Parameters getUserDataInfo(Parameters param) {

		JSONObject js = new JSONObject();
		try {

			String query = "select * from tbl_user where user_id='" + param.getUserid() + "'";
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			String message = "unSuccessfull";
			int status = 404;
			js.put("user", "User Not Found");
			if (rs.next()) {
				js = new JSONObject();
				js.put("points", rs.getString("total_points"));
				js.put("tickets", rs.getString("ticket"));
				message = "Successfull";
				status = 200;
			}

			JSONArray jsa = new JSONArray().put(js);
			JSONObject jso = new JSONObject();
			jso.put("data", jsa);
			jso.put("message", message);
			jso.put("status", status);
			param.setJson(jso);
			param.setStatus(status);
			;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return param;

	}

	public static void insertRedeemTicket(Parameters param) {

		String query = "insert into tbl_ticket_history (user_id,game_id,ticket) values('" + param.getUserid() + "','"
				+ param.getGameid() + "','" + param.getTicket() + "')";
		try {

			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void updateRedeemTicket(Parameters param) {

		try {
			int ticket = getUserTotalTicket(param) - 1;
			String query = "update tbl_user set ticket='" + ticket + "' where id='" + param.getUserid() + "'";
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Parameters getUserTicketPoints(Parameters param) {

		String query = "select * from tbl_user where user_id='" + param.getUserid() + "'";
		System.out.println(query);
		long points = 0;
		param.setPoints("0");
		param.setTicket("0");
		try {
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				points = Long.parseLong(rs.getString("user_points"));
				param.setPoints(rs.getString("user_points"));
				param.setTicket(rs.getString("ticket"));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return param;
	}

	public static String getIdfromAni(String ani) {
		String id = "";
		try {
			String query = "select * from  tbl_user where  user_id='" + ani + "'";

			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				id = rs.getString("id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public static String getAnifromId(String id) {
		String ani = "";
		try {
			String query = "select * from  tbl_user where  id='" + id + "'";

			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				ani = rs.getString("user_id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ani;
	}

	public static void updateOffnetUser(String ref, String ani) {

		try {
			String query = "update tbl_offnetuser set ani='" + ani + "' where ref='" + ref
					+ "' ORDER BY DATETIME DESC LIMIT 1";
			PreparedStatement ps = Loader.userconn.prepareStatement(query);
			System.out.println(query);
			ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static String getSdpUrl() {
		try {

			String query = "select guid_url from tbl_service_master where id=3";

			PreparedStatement ps = Loader.userconn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getSMSurl() {

		try {

			String query = "select sms_url from tbl_service_master where id=3";
			PreparedStatement ps = Loader.userconn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public static String getDemoUserDetails(String ani) {
		try {

			String query = "select datetime from tbl_demouser where ani=" + ani + "";
			PreparedStatement ps = Loader.conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);

		} catch (Exception e) {

			e.printStackTrace();
		}

		System.out.println(LocalDate.now().toString());
		return LocalDate.now().toString();
	}
}