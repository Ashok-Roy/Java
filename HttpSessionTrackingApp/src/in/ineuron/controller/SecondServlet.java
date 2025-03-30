package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Collect request parameter data
		String qual = request.getParameter("qual");
		String desi = request.getParameter("desi");
		
		// Create a session object and store the data in session object 
		HttpSession session = request.getSession();
		session.setAttribute("qual", qual);
		session.setAttribute("desi", desi);
		
		// Create a RequestDispatcher to send the request, response object to ThirdServlet
		RequestDispatcher rd = request.getRequestDispatcher("/form3.html");
		rd.forward(request, response);
	}

}
