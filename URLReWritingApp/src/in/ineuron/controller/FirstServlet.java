package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Getting the data from request parameter
		String accName = request.getParameter("accname");
		String accNum = request.getParameter("accnnum");
	
		// Set the attribute in session object 
		HttpSession session = request.getSession();
		session.setAttribute("accname", accName);
		session.setAttribute("accnnum", accNum);
		
		// Send the response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='lightgreen'>");
		out.println("<div align='center'>");
		out.println("<form action='"+response.encodeURL("./SecondServlet")+"' method='post'>");
		out.println("<table>");
		out.println("<tr><th>Account Type</th><td><input type='text' name='type'></td></tr>");
		out.println("<tr><th>Account Branch</th><td><input type='text' name='branch'></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='NEXT'></td></tr>");
	
		out.println("</table>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body");
		out.close();
		
		
	}

}
