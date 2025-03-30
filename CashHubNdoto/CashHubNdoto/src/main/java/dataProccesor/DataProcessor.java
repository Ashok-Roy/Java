package dataProccesor;

import java.sql.ResultSet;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.Parameters;
import datacollector.DataCollector;

public class DataProcessor {
	
	public static ResultSet getAllGames() {

		return DataCollector.getGames();

	}

	public static Map<String, String> getGame(String id) {

		return DataCollector.getParticularGame(id);

	}
	
	public static ResultSet getRewards()
	{
		
			return DataCollector.getGameRewards();
	
		}
	
	public static int  redeemPoints(Parameters param) {
	
		int status=0;
			long points = DataCollector.getpoints(param.getUserid());
			long redeempoint = Long.parseLong(param.getPoints());
	        System.out.println(points  + "::: " +redeempoint);
			if (points >= redeempoint) {
	
				points = points - redeempoint;
				System.out.println(points);
				DataCollector.updateUserPoints(param,points);
			    DataCollector.insertRedeemPoints(param);
				status=1;
			}
	
			else 
			{
				status=0;
			}
			
			return status;
			
			
				}

	public static long getPoints(Parameters param) {
		return DataCollector.getpoints(param.getUserid());
		
	}

	public static void insertPoints(Parameters param) {
		
		DataCollector.enterPoints(param);
		long points = DataCollector.getpoints(param.getUserid());
		points = Long.parseLong(param.getPoints())+points;
		DataCollector.updateUserPoints(param, points);
		
		
	}

	public static void updateTicket(Parameters param) {
		
		int ticket=DataCollector.insertUserTicket(param);
		DataCollector.updateUserTicket(param,ticket);
	}

	public static Parameters getUserData(Parameters param) {
		
		param=DataCollector.getUserDataInfo(param);
		
		
		return param;
	}

	public static int checkTickets(Parameters param) {
		
		int status=0;
		int userTotalTicket = DataCollector.getUserTotalTicket(param);
		
		if(userTotalTicket>0)
		{
//			DataCollector.updateRedeemTicket(param);
			
			status=1;
		}
//		param.setTicket(String.valueOf(status));
//		DataCollector.insertRedeemTicket(param);
		return status;
	}

	public static Parameters getPointsTicket(Parameters param) {
		
		
		param=DataCollector.getUserTicketPoints(param);
		
		return param;
	}
		
	}

