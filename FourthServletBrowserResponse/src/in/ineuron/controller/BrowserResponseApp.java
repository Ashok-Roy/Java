package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/test"}, loadOnStartup = 1)
public class BrowserResponseApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static{
		System.out.println("TestServlet Loading...");
	}
	public BrowserResponseApp()
	{
		System.out.println("TestServlet Instantiation...");
	}
	public void init()
	{
		System.out.println("TestServlet Initialization...");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Set the response content-type
		System.out.println("TestServlet Request Processing for GET request type");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>output</title></head>");
		out.println("<body><div align='center'>");
		
		out.println("<h1 text-align:'center'>Request Header Information</h1>");
		Enumeration<String> headerNames = request.getHeaderNames();
		out.println("<table border=1>");
		out.println("<tr><th>Header Names</th><th>Header Values</th></tr>");
		while(headerNames.hasMoreElements())
		{
			
			String headerName =(String)headerNames.nextElement();
			String headerValues = request.getHeader(headerName);
			out.println("<tr><td>"+headerName+"</td><td>"+headerValues+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div></body></html>");
		
		out.close();
	}
	public void destroy()
	{
		System.out.println("Servlet Deinstantiation...!");
	}
	

}
