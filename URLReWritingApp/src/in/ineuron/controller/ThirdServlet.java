package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Getting the data from request parameter
		String dName = request.getParameter("dname");
		String dAmount = request.getParameter("damount");
		
		
		
		HttpSession session = request.getSession();
		Object accName = session.getAttribute("accname");
		Object accNum = session.getAttribute("accnnum");
		Object accType = session.getAttribute("type");
		Object accBranch = session.getAttribute("branch");
		
		
		// Send the response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='lightgreen'>");
		out.println("<div align='center'>");
		
		out.println("<table border='1'>");
		out.println("<tr><th>Account Name</th><td>"+accName+"</td></tr>");
		out.println("<tr><th>Account Number</th><td>"+accNum+"</td></tr>");
		out.println("<tr><th>Account Type</th><td>"+accType+"</td></tr>");
		out.println("<tr><th>Account Branch</th><td>"+accBranch+"</td></tr>");
		out.println("<tr><th>Depositor Name</th><td>"+dName+"</td></tr>");
		out.println("<tr><th>Deposit Amount</th><td>"+dAmount+"</td></tr>");
		
	
		out.println("</table>");
		out.println("</div>");
		out.println("</body");
		out.close();
		
		
	}

}
