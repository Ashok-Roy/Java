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


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		System.out.println("Control is here");
		RequestDispatcher rd = null;
		String status = null;
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String newName = request.getParameter("name");
		String newEmail = request.getParameter("email");
		String newCity = request.getParameter("city");
		System.out.println(newName +" "+newEmail+" "+ newCity);
		Employee employee = null;
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		employee = employeeService.findById(id);
		if(employee != null)
		{
			Employee newEmployee = new Employee();
			newEmployee.setEid(id);
			if(newName == null || newName.equals(""))
			{
				newEmployee.setEname(employee.getEname());
			}else{
				newEmployee.setEname(newName);	
			}
			if(newEmail == null || newEmail.equals(""))
			{
				newEmployee.setEmail(employee.getEmail());
			}else{
				newEmployee.setEmail(newEmail);	
			}
			if(newCity == null || newCity.equals(""))
			{
				newEmployee.setCity(employee.getCity());
			}else{
				newEmployee.setCity(newCity);
			}
			
			status = employeeService.updateById(newEmployee);
			HttpSession session = request.getSession();
			if(status.equalsIgnoreCase("success"))
			{
				session.setAttribute("update", "Updation Successful");
				response.sendRedirect("./update.jsp");
//				rd = request.getRequestDispatcher("./success.html");
//				rd.forward(request, response);
			}else{
				
				session.setAttribute("update", "Updation Not Success!");
				response.sendRedirect("./update.jsp");
//				rd = request.getRequestDispatcher("./notFound.html");
//				rd.forward(request, response);
			}
			
		}else
		{
			rd = request.getRequestDispatcher("./notFound.html");
			rd.forward(request, response);
		}	
	}
}
