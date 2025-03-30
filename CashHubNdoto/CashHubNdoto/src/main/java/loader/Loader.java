package loader;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import dbconnection.DbConnection;

/**
 * Servlet implementation class Loader
 */
public class Loader extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static Connection conn=null;
	public static Connection userconn=null;

	
    public Loader() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		conn=DbConnection.getDbConn();
		userconn=DbConnection.getUserDbConn();
			
        
		super.init();
	}
}
