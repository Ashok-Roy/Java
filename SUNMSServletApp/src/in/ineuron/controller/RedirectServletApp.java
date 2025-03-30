package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Redirection through click on link 
		/*
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Redirec to the OcacleServletApp</title></head>");
		out.println("<body>");
		out.println("<h1>To get the service of Java Click below Link</h1>");
		out.println("<a href='http://localhost:8080/OracleServletApp/index.html'>CC@www.oracle.com</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		*/
		
		// Redirection through link without click
		String location="http://localhost:8080/OracleServletApp/index.html";
		response.sendRedirect(location);
		
	}

}
