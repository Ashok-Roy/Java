package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;


@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		RequestDispatcher rd = null; 
		PrintWriter out = response.getWriter();
		String status = "";
		Student student = new Student();
		String uri = request.getRequestURI();
		System.out.println(uri);
		if(uri.endsWith("layout"))
		{
			rd = request.getRequestDispatcher("../layout.html");
			rd.forward(request, response);
			
		}
		if(uri.endsWith("addform"))
		{
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			String country = request.getParameter("country");
			student.setName(name);
			student.setEmail(email);
			student.setCity(city);
			student.setCountry(country);
			status = studentService.save(student);
			if(status!= null)
			{
				rd = request.getRequestDispatcher("../success.html");
				rd.forward(request, response);
				//response.sendRedirect("../success.html");
			}else{
				rd = request.getRequestDispatcher("../failure.html");
				rd.forward(request, response);
				//response.sendRedirect("../failure.html");
				
			}
			
		}
		if(uri.endsWith("searchform"))
		{
			Integer sid = Integer.parseInt(request.getParameter("sid"));
			student = studentService.findById(sid);
			if(student != null)
			{
				out.println("<div align='center'>");
				out.println("<h3>Student Details</h3>");
				out.println("<table border='1'");
				out.println("<thead><tr><th>ID</th>");
				out.println("<th>Name</th>");
				out.println("<th>Email</th>");
				out.println("<th>City</th>");
				out.println("<th>Country</th></tr></thead>");
				
				out.println("<tr><td>"+student.getSid()+"</td>");
				out.println("<td>"+student.getName()+"</td>");
				out.println("<td>"+student.getEmail()+"</td>");
				out.println("<td>"+student.getCity()+"</td>");
				out.println("<td>"+student.getCountry()+"</td></tr>");
				out.println("</table></div>");
				
			}else{
				rd = request.getRequestDispatcher("../failure.html");
				rd.forward(request, response);
			}
		}
		if(uri.endsWith("deleteform"))
		{
			Integer sid = Integer.parseInt(request.getParameter("sid"));
			status = studentService.deleteById(sid);
			if(status.equals("success"))
			{
				rd = request.getRequestDispatcher("../success.html");
				rd.forward(request, response);
			}else{
				rd = request.getRequestDispatcher("../failure.html");
				rd.forward(request, response);
			}
		}
		
		
		if(uri.endsWith("editform"))
		{
			Integer id = Integer.parseInt(request.getParameter("sid"));
			student = studentService.findById(id);
			if(student != null)
			{
				response.setContentType("text/html");
				out.println("<div align='center'>");
				out.println("<h3>Student Details</h3>");
				out.println("<form action='./update' method='post'>");
				out.println("<table>");
				
				out.println("<tr><td>Id</td><td>"+student.getSid()+"</td>");
				out.println("<td><input type='hidden' name='sid' value ='"+student.getSid()+"'/></td></tr>");
				out.println("<tr><td>Name</td>");
				out.println("<td><input type='text' name='name' value = '"+student.getName()+"'/></td></tr>");
				out.println("<tr><td>Email</td>");
				out.println("<td><input type='text' name='email' value ='"+student.getEmail()+"'/></td></tr>");
				out.println("<tr><td>City</td>");
				out.println("<td><input type='text' name='city' value ='"+student.getCity()+"'/></td></tr>");
				out.println("<tr><td>Country</td>");
				out.println("<td><input type='text' name='country' value ='"+student.getCountry()+"'/></td></tr>");
				out.println("<tr><td></td><td><input type='submit' value='Update'/></td></tr>");
				
				out.println("</table> </form></div>");
				
			}else{
				response.setContentType("text/html");
				out.println("<div align='center'><h1>Record Not Found</h1></div>");
			}
			
		}
		if(uri.endsWith("update"))
		{
			Integer sid = Integer.parseInt(request.getParameter("sid"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			String country = request.getParameter("country");
			Student newStudent = new Student();
			newStudent.setSid(sid);
			newStudent.setName(name);
			newStudent.setEmail(email);
			newStudent.setCity(city);
			newStudent.setCountry(country);
			status = studentService.updateById(newStudent);
			if(status.equalsIgnoreCase("success"))
			{
				response.sendRedirect("../success.html");
				//rd.forward(request, response);
			}else{
				
				rd = request.getRequestDispatcher("../failure.html");
				rd.forward(request, response);
			}
		}
		
	}

}
