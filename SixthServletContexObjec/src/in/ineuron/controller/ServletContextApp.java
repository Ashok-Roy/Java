package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static{
		System.out.println("Servlet loading...");
	}
	public ServletContextApp()
	{
		System.out.println("Servlet Instantiation...");
	}
	public void init()throws ServletException{
		System.out.println("Servlet Initialization...");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set the Attributes using context object 
		ServletContext context = getServletContext();
		

		context.setAttribute("iNeuron", "Navin Reddy");
		context.setAttribute("Google", "SundarPichai");
		context.setAttribute("MicroSoft", "Bill Gates");
		// Setting the response object 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body><div align='center'>");
		out.println("<table border='1'>");
		out.println("<tr><th>Context Parameter Names</th><th>Context Parameter Value</th></tr>");
		// Get the parameter from context object in web.xml
		Enumeration<String> parameternames = context.getInitParameterNames();
		while(parameternames.hasMoreElements())
		{
			String parametername = (String)parameternames.nextElement();
			String parametervalue = context.getInitParameter(parametername);
			out.println("<tr><td>"+parametername+"</td>");
			out.println("<td>"+parametervalue+"</td></tr>");
		}		
		// Get the Attributes using context object 
		Enumeration<String> attributenames = context.getAttributeNames();
		out.println("<tr><th>Context Attributes Names</th><th>Context Attribute Values</th></tr>");
		while(attributenames.hasMoreElements())
		{
			String attributename = (String)attributenames.nextElement();
			Object attributevalue = context.getAttribute(attributename);
			out.println("<tr><td>"+attributename+"</td>");
			out.println("<td>"+attributevalue+"</td></tr>");
		}	
		
		out.println("</table>");
		out.println("</body></html>");
		out.close();
		
	}
	public void destroy()
	{
		System.out.println("Servlet Destroy...");
	}

}
