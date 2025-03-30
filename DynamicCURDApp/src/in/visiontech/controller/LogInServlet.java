package in.visiontech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.visiontech.dto.Employee;
import in.visiontech.factory.EmployeeServiceFactory;
import in.visiontech.service.IEmployeeService;


@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		Employee employee = null;
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		employee = employeeService.findById(id);
		if(employee != null)
		{
			
			String mail = employee.getEmail();
			String name = employee.getEname();
			if(email.equals(mail))
			{
				session.setAttribute("name", name);
				response.sendRedirect("./index.jsp");
			}else
			{
				session.setAttribute("incorrect", "Record Not Available or Email Incorrect");
				response.sendRedirect("./login.jsp");
			}
			
		}
		else{
			session.setAttribute("rnf", "Record Not Available");
			response.sendRedirect("./index.jsp");
		}
		
	}

}
