package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test" )
public class ServletRequestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static{
		System.out.println("Servlet Loading...");
	}
	public ServletRequestApp(){
		System.out.println("Servlet Instantiation...");
	}
	@Override
	public void init()
	{
		System.out.println("Servlet Initailization...");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request processing for POST type");
		
		System.out.println("Request object id: " + request.hashCode());
		System.out.println("Response object id: " + response.hashCode());
		System.out.println("Current Thread object: " + Thread.currentThread().hashCode());
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		//to get multiple values 
		String[] courses = request.getParameterValues("course");
		
		
		// Response for the user
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Output</title></head>");
		out.println("<body style='background-color:powderblue' align='center'>");
		out.println("<div align='center'>");
		out.println("<h3 text-align:center >Student Course Details</h3>");
		out.println("<table border='1'><tr><th>Name</th><td>"+name+"</td></tr>");
		out.println("<tr><th>Email</th><td>"+email+"</td></tr>");
		out.println("<tr><th>Contact Number</th><td>"+number+"</td></tr>");
		
		out.println("<tr><th>Courses</th>");
		out.println("<td>");
		for (String course : courses)
		{
			out.println(course+"<br>");
		}
		out.println("</td></tr>");
		out.println("<tr><th>Request Object id </th><td>"+request.hashCode()+"</td></tr>");
		out.println("<tr><th>Response Object id </th><td>"+response.hashCode()+"</td></tr>");
		out.println("<tr><th>Current Thread Object id </th><td>"+Thread.currentThread().hashCode()+"</td></tr>");
		out.println("</table></div></body></html>");
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		out.close();
		
	}

}
