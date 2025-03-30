package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the request parameter data from form1
		String pid = request.getParameter("pid");
		String pname= request.getParameter("pname");
		
		//Create Cookie as per the requirement 
		Cookie c1 = new Cookie("pid", pid);
		Cookie c2 = new Cookie("pname", pname);
		response.addCookie(c1);
		response.addCookie(c2);
		//forward the response to form2.html 
		RequestDispatcher rd = request.getRequestDispatcher("/form2.html");
		rd.forward(request, response);
	}

}
