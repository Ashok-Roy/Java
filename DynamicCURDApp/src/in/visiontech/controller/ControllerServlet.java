package in.visiontech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.visiontech.dto.Employee;
import in.visiontech.factory.EmployeeServiceFactory;
import in.visiontech.service.IEmployeeService;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//doProcess(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = null;
		//String create = request.getParameter("create");
		//String read = request.getParameter("read");
		//if(create.equalsIgnoreCase("create"))
		//{
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			
			Employee employee = new Employee();
			employee.setEname(name);
			employee.setEmail(email);
			employee.setCity(city);
			
			
			IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
			String status = employeeService.save(employee);
//			String requestURI = request.getRequestURI();
//			System.out.println(requestURI);
//			if (requestURI.endsWith("index")) {
//				rd = request.getRequestDispatcher("./add.html");
//				rd.forward(request, response);
//			}
			HttpSession session = request.getSession();
			if (status.equals("success")) 
			{
				session.setAttribute("success", "Data Insertion Successful");
				response.sendRedirect("./insert.jsp");
				
			} else {
				session.setAttribute("fail", "OOPs! Data Insertion Fail");
				response.sendRedirect("./insert.jsp");
			}
		//}
//		if(read.equalsIgnoreCase("read"))
//		{
//			Integer id = Integer.parseInt(request.getParameter("id"));
//			System.out.println(id);
//			Employee employee = null;
//			IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
//			employee = employeeService.findById(id);
//			if(employee != null)
//			{
//				System.out.println(employee);
//				request.setAttribute("id", employee.getEid());
//				request.setAttribute("name", employee.getEname());
//				request.setAttribute("email", employee.getEmail());
//				request.setAttribute("city", employee.getCity());
//				rd = request.getRequestDispatcher("./read.jsp");
//				rd.forward(request, response);
//			}else
//			{
//				rd = request.getRequestDispatcher("./notFound.html");
//				rd.forward(request, response);
//			}
//		}
			
			
	}
}
