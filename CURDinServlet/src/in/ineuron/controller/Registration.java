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
		urlPatterns = {"/reg" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/newone"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement pstmt = null;
	static{
		System.out.println("Registration servlet loading...");
	}
	public Registration()
	{
		System.out.println("Registration servlet instantiation...");
	}
	public void init() throws ServletException
	{
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
		//1. Get the data from request object
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		//2. Use JDBC API to send the data to DB
		String inserQuery = "insert into student(name, email, city, country)values(?,?,?,?)";
		int rowCount = 0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(connection!= null)
				pstmt = connection.prepareStatement(inserQuery);
			if(pstmt != null)
			{
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.setString(3, city);
				pstmt.setString(4, country);
				
				rowCount = pstmt.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		
		//3. make response object 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body><div align='center'>");
		if(rowCount == 1)
		{
			out.println("<h1  style='color:green'>REGITRATION SUCCESSFUL</h1>");
		}else{
			out.println("<h1  style='color:red'>REGITRATION FAILED</h1>");
			out.println("<a  style='color:red' href='./registration.html'>Register Again</a>");
		}
		out.println("</div></body></html>");
		out.close();

	}
	public void destroy()
	{
		System.out.println("Registration servlet destroy...");
	}

}
