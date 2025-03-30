package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static{
		System.out.println("Servlet Loading...");
	}
    public SecondServlet() {
       System.out.println("Servlet Instantiation ...");
    }
    @Override
    public void init() throws ServletException
    {
    	super.init();
    	ServletConfig config = getServletConfig();
    	System.out.println("Config object is :"+config);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body>");
		out.println("<h1>Getting the response for GET request type</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body>");
		out.println("<h1>Getting the response for POST request type</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	
	}
	@Override
	public void destroy()
	{
		System.out.println("DeInstantiation of Servlet...");
	}
}
