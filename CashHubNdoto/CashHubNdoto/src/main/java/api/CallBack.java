package api;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/adhocbiling")
public class CallBack extends HttpServlet {
	
	
	/**
	 * Vijay Author
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	Logger log=Logger.getLogger(this.getClass());
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		BufferedReader bf=req.getReader();
		StringBuffer sb=new StringBuffer();
		String line="";
		while((line=bf.readLine())!=null) {
			sb.append(line);
			
			}
		System.out.println(sb);
		log.info("CalBack For Ticket ======= "+line);
		
		
		
		
		
		
		
	}

}
