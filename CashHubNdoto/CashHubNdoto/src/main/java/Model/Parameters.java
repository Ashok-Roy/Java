package Model;

import org.json.JSONObject;

public class Parameters {

	
	public String error="{\"message\":\"vallue is missed\",\"status\":\"400\"}";
	public String success="{\"message\":\"Successfully Updated\",\"status\":\"200\"}";
	private String points,type,action,userid,gameid,ticket;
	private JSONObject json;
    int status;
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getGameid() {
		return gameid;
	}

	public void setGameid(String gameid) {
		this.gameid = gameid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getType() {
		return type;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public void setType(String type) {
		this.type = type;
	}
}
