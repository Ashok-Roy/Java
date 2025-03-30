package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the request parameter data from form3
		String manuDate = request.getParameter("m_date");
		String expireDate = request.getParameter("e_date");
		
		// Collect the cookies from request object 
		Cookie[] cookies = request.getCookies();
		String pid = cookies[0].getValue();
		String pname = cookies[1].getValue();
		String pcost = cookies[2].getValue();
		String pquantity = cookies[3].getValue();
		
		// Send the response to the browser as html
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<div align='center'>");
		out.println("<table border='1' bgcolor='lightgreen'>");
		out.println("<tr><th>Product ID</th><td>"+pid+"</td></tr>");
		out.println("<tr><th>Product Name</th><td>"+pname+"</td></tr>");
		out.println("<tr><th>Product Cost</th><td>"+pcost+"</td></tr>");
		out.println("<tr><th>Product Quantity</th><td>"+pquantity+"</td></tr>");
		out.println("<tr><th>Manufacture Date</th><td>"+manuDate+"</td></tr>");
		out.println("<tr><th>Expire Date</th><td>"+expireDate+"</td></tr>");
		
		
		out.println("</table>");
		out.println("</div >");
		
	}

}
