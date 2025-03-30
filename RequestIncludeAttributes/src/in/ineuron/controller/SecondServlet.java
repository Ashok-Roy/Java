package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("Request object " + request.hashCode());
		System.out.println("Response object " + response.hashCode());
		System.out.println("PrintWriter object " + out.hashCode());
		
		
		out.println("<table border='1'>");
		out.println("<tr><th>Names</th><th>Values</th></tr>");
		Enumeration<String> attributeNames = request.getAttributeNames();
		while(attributeNames.hasMoreElements())
		{
			String name = (String)attributeNames.nextElement();
			Object value = request.getAttribute(name);
			out.println("<tr>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

}
