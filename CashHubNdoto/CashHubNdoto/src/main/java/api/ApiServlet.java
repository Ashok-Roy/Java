package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import Model.Parameters;
import static datacollector.CheckSubscription.*;
@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet  {

	Parameters param=new Parameters();

	private static final long serialVersionUID = 1L;
   
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      	PrintWriter out=resp.getWriter();
		
		try {
			
			
			param.setAction(req.getParameter("action"));
	        
			System.out.println(req.getQueryString());
			// bottom code is not use in this portal
//			if(param.getAction().equalsIgnoreCase("1"))
//			{	
//				param.setUserid(req.getParameter("userid"));
//				param.setType(req.getParameter("type"));
//				param.setPoints(req.getParameter("points"));
//				int status= redeemPoints(param);
//				out.print(new JSONObject().put("status", status));
//				   
//			}
//			
//			else if(param.getAction().equalsIgnoreCase("2"))
//			{
//				JSONObject js = new JSONObject();
//				param.setUserid(req.getParameter("userid"));
//				long points=getPoints(param);
//				out.print(new JSONObject().put("point", points));
//			
//			}
//			else if(param.getAction().equalsIgnoreCase("3"))
//			{
//				param.setUserid(req.getParameter("userid"));
//				param.setGameid(req.getParameter("gameid"));
//				int status=checkTickets(param);
//				out.print(new JSONObject().put("status", status));
//			    resp.setStatus(200);
//			}
//			else if(param.getAction().equalsIgnoreCase("4"))
//			{
//				System.out.println("enter in action");
//				JSONObject js = new JSONObject();
//				param.setUserid(req.getParameter("userid"));
//				param=getPointsTicket(param);
//				js.put("point", param.getPoints());
//				js.put("ticket", param.getTicket());
//			    System.out.println(js.toString());
//				out.print(js.toString());
//			
//			}
			
			 if(param.getAction().equalsIgnoreCase("5"))
			{
				System.out.println("check user ::: ");
				param.setUserid(req.getParameter("userid"));
				out.println(new  JSONObject().put("status", checkUserInSubscription(param.getUserid())));
			}
		}
		catch(Exception e)
		{
		    e.printStackTrace();	
			
		}
		
		
		
		
	}


	
	
}
