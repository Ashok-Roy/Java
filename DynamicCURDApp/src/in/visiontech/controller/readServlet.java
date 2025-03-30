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

@WebServlet("/readServlet")
public class readServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = null;
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Employee employee = null;
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		employee = employeeService.findById(id);
		
		if(employee != null)
		{
			System.out.println(employee);
			request.setAttribute("id", employee.getEid());
			request.setAttribute("name", employee.getEname());
			request.setAttribute("email", employee.getEmail());
			request.setAttribute("city", employee.getCity());
			rd = request.getRequestDispatcher("./read.jsp");
			rd.forward(request, response);
		}else
		{
			HttpSession session = request.getSession();
			session.setAttribute("notfound", "Record Not Found!");
			response.sendRedirect("./searchbyid.jsp");
//			rd = request.getRequestDispatcher("./notFound.html");
//			rd.forward(request, response);
		}
		
	}

}
