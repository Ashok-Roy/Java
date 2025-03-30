package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the request parameter data from form2
		String pcost = request.getParameter("pcost");
		String pquantity = request.getParameter("quantity");
				
		//Create Cookie as per the requirement 
		Cookie c3 = new Cookie("pcost", pcost);
		Cookie c4 = new Cookie("pquantity", pquantity);
		response.addCookie(c3);
		response.addCookie(c4);		
		//forward the response to form3.html 
		RequestDispatcher rd = request.getRequestDispatcher("/form3.html");
		rd.forward(request, response);
	}

}
