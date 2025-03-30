package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");
		String sage = request.getParameter("sage");
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='lightgreen'>");
		out.println("<div align='center'>");
		out.println("<form action='./DisplayServlet' method='post'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>SMAIL</td>");
		out.println("<td><input type='text' name='smail'></td>");
		out.println("<td><input type='hidden' name='sage' value='"+sage+"'></td>");
		out.println("<td><input type='hidden' name='sid' value='"+sid+"'></td>");
		out.println("<td><input type='hidden' name='sname' value='"+sname+"'></td>");
		out.println("<td><input type='hidden' name='saddr' value='"+saddr+"'></td>");
		out.println("<td><input type='submit' value='Next'></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");

		out.println("</div>");
		out.println("</body> ");
		
		out.close();
	}
}
