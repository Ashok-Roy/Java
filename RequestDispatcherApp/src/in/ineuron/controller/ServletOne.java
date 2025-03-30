package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Default response type is "text/html" only
		//science it is text/html only autometically response object will be hold
		//<html><head></head><body></body></html> this will done autometically 
		
		// Servlet 1 response object 
		PrintWriter out = response.getWriter();
		out.println("<h1>Servlet One response object triggered");
		
		// Servlet 1 response and request object forward to the Servlet-2
		RequestDispatcher rd = request.getRequestDispatcher("/ServletTwo");
		rd.forward(request, response);
		out.close();
	}

}
