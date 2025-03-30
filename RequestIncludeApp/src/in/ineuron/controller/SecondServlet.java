package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>Response from second servlet</h2>");
		
		System.out.println("Control in Second Servlet");
		System.out.println("Request object :" + request.hashCode());
		System.out.println("Response object :" + response.hashCode());
		System.out.println("PrintWriter object :" + out.hashCode());
		
		// if we close the out here then control will go in FirstServlet
		// but FirstServlet response will not send to browser/user
		// because both servlet are using same PrintWriter object 
		// that's why hashCode value is same for both servlet out object.
		// out.close();
	}

}
