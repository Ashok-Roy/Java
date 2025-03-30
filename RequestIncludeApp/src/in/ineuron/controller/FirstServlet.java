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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>Response from first servlet...");
		
		RequestDispatcher rd = request.getRequestDispatcher("/SecondServlet");
		rd.include(request, response);
		
		System.out.println("Control in First Servlet");
		System.out.println("Request object :" + request.hashCode());
		System.out.println("Response object :" + response.hashCode());
		System.out.println("PrintWriter object :" + out.hashCode());
		out.println("<h1>Control come to the First servlet</h1>");
		out.println("<h1>Response from First servlet again</h1>");
		out.close();
		
	}

}
