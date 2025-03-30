package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Getting the data from request parameter
		String accType = request.getParameter("type");
		String accBranch = request.getParameter("branch");
		
		HttpSession session = request.getSession();
		session.setAttribute("type", accType);
		session.setAttribute("branch", accBranch);
		
		// Send the response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='lightgreen'>");
		out.println("<div align='center'>");
		out.println("<form action='"+response.encodeURL("./ThirdServlet")+"' method='post'>");
		out.println("<table>");
		out.println("<tr><th>Depsitor Name</th><td><input type='text' name='dname'></td></tr>");
		out.println("<tr><th>Deposit Amount</th><td><input type='text' name='damount'></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='NEXT'></td></tr>");
	
		out.println("</table>");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body");
		out.close();
		
		
	}

}
