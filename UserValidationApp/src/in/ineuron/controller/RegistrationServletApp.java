package in.ineuron.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/RegistrationServletApp" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/newone"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class RegistrationServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	static{
		System.out.println("RegistrationServlet loading...");
	}
    public RegistrationServletApp() {
    	System.out.println("RegistrationServlet Instantiation...");
    }
    public void init() throws ServletException
	{
		System.out.println("RegistrationServlet Instantiation...");
		
		ServletConfig config = getServletConfig();
		String url = config.getInitParameter("url");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		
		try{
			
			String inserQuery = "insert into userone(name, email, contact, password)values(?,?,?,?)";
			if(connection != null)
			{
				
				pstmt = connection.prepareStatement(inserQuery );
			}
			if(pstmt != null)
			{
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.setString(3, contact);
				pstmt.setString(4, password);
				
				int rowCount = pstmt.executeUpdate();
				if(rowCount == 1){
					System.out.println("No of row affect"+rowCount);
					RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
					rd.forward(request, response);
					//response.sendRedirect("./login.jsp");
				}else{
					response.sendError(504,"Registration Invalid");
				}
			}
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
				
	
	}

}
