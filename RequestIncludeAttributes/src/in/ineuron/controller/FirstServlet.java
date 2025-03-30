package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		System.out.println("Request object " + request.hashCode());
		System.out.println("Response object " + response.hashCode());
		System.out.println("PrintWriter object " + out.hashCode());
		
		request.setAttribute("Sachin", "Cricket");
		request.setAttribute("NavinReddy", "Java");
		request.setAttribute("Messi", "Football");
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/SecondServlet");
		rd.include(request, response);
	}

}
