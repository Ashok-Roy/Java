package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
	urlPatterns = { "/demo" }, 
	initParams = { 
		@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/newone"), 
		@WebInitParam(name = "user", value = "root"), 
		@WebInitParam(name = "password", value = "root")
	})
public class ServletConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static{
		System.out.println("Demo Servlet loading...");
	}
	public ServletConfigDemo()
	{
		System.out.println("Demo servlet instantiation...");
		
	}
	public void init() throws ServletException
	{
		System.out.println("Demo servlet initialization...");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		ServletConfig config = getServletConfig();
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body><div align='center'>");
		out.println("<h1 text-align='center'>ServletConfig Object With Xml</h1>");
		out.println("<table border='1'><tr><th>JDBC Connection</th><th>Values</th></tr>");
		Enumeration<String> parameternames = config.getInitParameterNames();
		while(parameternames.hasMoreElements())
		{
			String parametername = (String)parameternames.nextElement();
			String parametervalue = config.getInitParameter(parametername);
			out.println("<tr><td>"+parametername+"</td><td>"+parametervalue+"</td></tr>");
			
		}
		
		out.println("<tr><th>Company</th><td>"+config.getInitParameter("Company")+"</td></tr>");

		
		out.println("</table></div></body></html>");
		out.close();
	}
	public void destroy()
	{
		System.out.println("Demo servlet destroy...");
	}

}
