package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Demo servlet forward the request and response object...");
		RequestDispatcher rd = request.getRequestDispatcher("/ServletTest");
		rd.forward(request, response);
		
		System.out.println("After forwarding control comes again");
		out.println("<h1>Response object of Demo servlet</h1>");
		System.out.println(10/0); // prove in console 
		
		
	}
	
	

}
