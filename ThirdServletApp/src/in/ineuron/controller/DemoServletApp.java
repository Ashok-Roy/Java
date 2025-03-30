package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns ={"/DemoServletApp"}, loadOnStartup=10)
public class DemoServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static{
		System.out.println("Demo servlet loading..");
	}
	public DemoServletApp()
	{
		System.out.println("Demo servlet instantiation...");
	}
	public void init()
	{
		System.out.println("Demo servlet initailization....");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request processing for GET request type");
		System.out.println("Client Ip address is :  "+ request.getRemoteAddr());
		System.out.println("Client host is :  "+ request.getRemoteHost());
		System.out.println("Client port number is :  "+ request.getRemotePort());
		System.out.println("Server Name is :  "+ request.getServerName());
		System.out.println("Server Port is :  "+ request.getServerPort());
		
	}
	public void destroy()
	{
		System.out.println("Demo servlet deinstantiation...");
	}

}
