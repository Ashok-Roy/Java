package api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Model.Parameters;
import dataProccesor.DataProcessor;

@WebServlet("/Notify")
public class Notify extends HttpServlet{
	
	Parameters param=new Parameters();
	
	
	@Override
	public void init() throws ServletException {
		
		super.init();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	     	PrintWriter out=resp.getWriter();
	     	
	     	//userid=123&gameid=12&points=784&action=1
	     	
	     	//userid=123&ticket=1&action=2
	     	
	     	try {
	     	param.setAction(req.getParameter("action"));
	     	
	     	
	     	if(param.getAction().equalsIgnoreCase("1"))
	     	{
	     		param.setUserid(req.getParameter("userid"));
		     	param.setPoints(req.getParameter("points"));
		     	param.setGameid(req.getParameter("gameid"));
		     	
		     	if(param.getUserid().equalsIgnoreCase("") || param.getPoints().equalsIgnoreCase("")  || param.getGameid().equalsIgnoreCase("") )
		     	{
		     		resp.setStatus(resp.SC_BAD_REQUEST);
		     		out.print(param.error);
		     		return;
		     	}
		     	 
				     	DataProcessor.insertPoints(param);
			     		resp.setStatus(resp.SC_OK);
			     		out.print(param.success);
	     	}
	     	else if(param.getAction().equalsIgnoreCase("2"))
	     	{
	     		
	     		param.setUserid(req.getParameter("userid"));
		     	param.setTicket(req.getParameter("ticket"));
		     	
		     	if(param.getUserid().equalsIgnoreCase("") || param.getTicket().equalsIgnoreCase(""))
		     	{
			     		resp.setStatus(resp.SC_BAD_REQUEST);
			     		out.print(param.error);
			     		return;
		     	}
		     	
		     	else
		     		{
				     		DataProcessor.updateTicket(param);
				     		resp.setStatus(resp.SC_OK);
//				     		out.print(param.success);
				     		out.print(new JSONObject().put("flag",1));
				     		return;
		     		}
			     		
	     		
	     	}
	     
	     	else if(param.getAction().equalsIgnoreCase("3"))
	     	{
	     		
	     		param.setUserid(req.getParameter("userid"));
	     		if(param.getUserid().equalsIgnoreCase(""))
		     	{
			     		resp.setStatus(resp.SC_BAD_REQUEST);
			     		out.print(param.error);
			     		return;
		     	}
		     	
				    param= 	DataProcessor.getUserData(param);
			     		resp.setStatus(param.getStatus());
			     		out.print(param.getJson());
	     		
	     		return;
	     		
	     	}
	     	
	     	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		resp.setStatus(resp.SC_INTERNAL_SERVER_ERROR);
	    		out.print("Something Went Wrong !!");
	    	}
	}
	

}
