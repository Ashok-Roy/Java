package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test3")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Collect request parameter data
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		// Create a session object and store the data in session object 
		// although no need we can collect this two from request parameter
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		session.setAttribute("mobile", mobile);
		
		//create a html page take data from session and send the response 
		
		Object name = session.getAttribute("name");
		Object age = session.getAttribute("age");
		Object qualification = session.getAttribute("qual");
		Object designation = session.getAttribute("desi");
		Object mail = session.getAttribute("email");
		Object num = session.getAttribute("mobile");
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title></title></head>");
		out.print("<body><div align='center'>");
		out.print("<table border='1' bgcolor='cyan'>");
		out.print("<tr><td>Name</td><td>"+name+"</td></tr>");
		out.print("<tr><td>Age</td><td>"+age+"</td></tr>");
		out.print("<tr><td>Qualification</td><td>"+qualification+"</td></tr>");
		out.print("<tr><td>Designation</td><td>"+designation+"</td></tr>");
		out.print("<tr><td>Email</td><td>"+mail+"</td></tr>");
		out.print("<tr><td>Mobile</td><td>"+num+"</td></tr>");
		
		out.print("</table>");
		out.println("</div></body>");
		out.println("</html>");
		
		out.close();
	}

}
