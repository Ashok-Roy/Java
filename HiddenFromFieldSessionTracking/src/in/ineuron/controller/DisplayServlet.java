package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");
		String sage = request.getParameter("sage");
		String smail = request.getParameter("smail");
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='lightgreen'>");
		out.println("<div align='center'>");
		out.println("<h1>Student Details</h1>");
		out.println("<table border='1'>");
		
		out.println("<tr><td>Student ID</td><td>"+sid+"</td></tr>");
		out.println("<tr><td>Student Name</td><td>"+sname+"</td></tr>");
		out.println("<tr><td>Student Age</td><td>"+sage+"</td></tr>");
		out.println("<tr><td>Student Address</td><td>"+saddr+"</td></tr>");
		out.println("<tr><td>Student Mail</td><td>"+smail+"</td></tr>");
		
		out.println("</table>");

		out.println("</div>");
		out.println("</body> ");
		
		out.close();
	}

}
