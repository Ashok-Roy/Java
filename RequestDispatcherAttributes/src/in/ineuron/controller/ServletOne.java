package in.ineuron.controller;

import java.io.IOException;

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
		request.setAttribute("Sachin", "Cricketer");
		request.setAttribute("NavinReddy", "Java");
		request.setAttribute("Messi", "Football");
		
		RequestDispatcher rd = request.getRequestDispatcher("/ServletTwo");
		rd.forward(request, response);
	}


}
