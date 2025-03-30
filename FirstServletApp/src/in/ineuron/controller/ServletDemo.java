package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static{
		System.out.println("Loading of servlet...");
	}
    public ServletDemo() {
        System.out.println("Instantiation of servlet...");
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Initialization of servlet...");
	}
	public void destroy() {
		System.out.println("Destroy of servlet...");
	}
	public ServletConfig getServletConfig() {
		
		return null;
	}


	public String getServletInfo() {
		
		return null; 
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service of servlet...");
	}

}
