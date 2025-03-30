package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTwo")
public class ServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Enumeration<String> attributeNames = request.getAttributeNames();
		out.println("<table border='1'>");
		out.println("<tr><th>Names</th><th>Values</th></tr>");
		while(attributeNames.hasMoreElements())
		{
			String name =(String)attributeNames.nextElement();
			Object value =request.getAttribute(name);
			out.println("<tr><td>"+name+"</td>");
			out.println("<td>"+value+"</td></tr>");
		}
		out.println("</table>");

	}


}
