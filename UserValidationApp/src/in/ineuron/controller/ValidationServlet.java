package in.ineuron.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		urlPatterns = { "/ValidationServlet" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/newone"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;
	static{
		System.out.println("ValidationServlet loading...");
	}
    public ValidationServlet() {
    	System.out.println("ValidationServlet Instantiation...");
    }
    public void init() throws ServletException
	{
		System.out.println("ValidationServlet Instantiation...");
		
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
		String password = request.getParameter("password");
		
		try
		{
			String dbname="";
			String dbpassword="";
			String selectQuery ="select name, password from userone where name=?";
			System.out.println(selectQuery);
			if(connection != null)
				pstmt = connection.prepareStatement(selectQuery );
			if(pstmt != null)
			{
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
			}
			if(rs != null)
			{
				if(rs.next())
				{
					dbname = rs.getString("name");
					dbpassword = rs.getString("password");
				}
			}
			if(dbname.equals(name) && dbpassword.equals(password))
			{
				//response.sendRedirect("./logSuccessful.jsp");
				request.setAttribute("name", name);
				RequestDispatcher rd = request.getRequestDispatcher("./logSuccessful.jsp");
				rd.forward(request, response);
				
			}else{
				//response.sendRedirect("./error.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("./error.jsp");
				rd.forward(request, response);
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
