package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/reg" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/newone"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class ServletErrorResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement pstmt = null;

	static{
		System.out.println("Servlet loading...");
	}
	public ServletErrorResponse()
	{
		System.out.println("Servlet Instantiation...");
	}
	public void init() throws ServletException
	{
		System.out.println("Servlet Initialization...");
		
		ServletConfig config = getServletConfig();
		String url = config.getInitParameter("url");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		try {
			
			
			connection = DriverManager.getConnection(url,user,password);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try 
		{
			if(age<19 || age>30)
			{
				response.sendError(504, "Age is not sufficent to Register");
			}else
			{
				String insertQuery="insert into error(name, age, email, contact)values(?,?,?,?)";
				int rowCount= 0;
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				if(connection != null)
					pstmt = connection.prepareStatement(insertQuery);
				if(pstmt != null)
				{
					pstmt.setString(1, name);
					pstmt.setInt(2, age);
					pstmt.setString(3, email);
					pstmt.setString(4, contact);
					
					rowCount = pstmt.executeUpdate();
					out.println("<html><head><title>Output</title></head>");
					out.println("<body><div align='center'>");
					out.println("<table border ='1'>");
					out.println("<tr><th>User</th><th>User Details</th><tr>");
					out.println("<tr><td>Name</td><td>"+name+"</td></tr>");
					out.println("<tr><td>Age</td><td>"+age+"</td></tr>");
					out.println("<tr><td>Email</td><td>"+email+"</td></tr>");
					out.println("<tr><td>Contact</td><td>"+contact+"</td></tr>");
					if(rowCount == 1){
						out.println("<tr><td>Registration Status</td><td>SUCCESSFULL</td></tr>");
					}else{
						out.println("<tr><td>Registration Status</td><td>FAILED</td></tr>");	
					}
					out.println("</table>");
					out.println("</div></body>");
					out.println("</html>");
					
					out.close();
				}
			}
			
			
		}catch (SQLException e){
				e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void destroy()
	{
		System.out.println("Servlet Destroy...");
	}

}
