package in.ineuron.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/image"}, loadOnStartup = 1)
public class ServletImageProcessingApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static{
		System.out.println("Servlet loading...");
	}
	public ServletImageProcessingApp()
	{
		System.out.println("Servlet instantiation...");
	}
	public void init()
	{
		System.out.println("Servlet initailization...");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set the response object 
		response.setContentType("image/jpg");
		// write the response object 
		ServletOutputStream sos = response.getOutputStream();
		//get the path of image
		String path = getServletContext().getRealPath("ashok.jpg");
		System.out.println(path);
		
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		
		byte[] b = new byte[(int)file.length()];
		//reading and placing the data in byte array(file to java)
		fis.read(b);
		
		
		//writing the data as the response from the byte array(java to browser)
		sos.write(b);
		sos.flush(); 
		fis.close();
	}
	public void destroy()
	{
		System.out.println("Servlet destroy...");
	}

}
