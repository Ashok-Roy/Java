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

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String status = null;
		RequestDispatcher rd = null;
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Employee employee = null;
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		employee = employeeService.findById(id);
		if(employee != null)
		{
			status = employeeService.deleteById(id);
			if(status == "success")
			{
				session.setAttribute("delete", "Delete Successful");
				response.sendRedirect("./deletebyid.jsp");
//				rd = request.getRequestDispatcher("./deletesuccess.html");
//				rd.forward(request, response);
			}else if(status == "fail")
			{
				session.setAttribute("fail", "Delete Fail");
				response.sendRedirect("./deletebyid.jsp");
//				rd = request.getRequestDispatcher("./dfail.html");
//				rd.forward(request, response);
			}
		}else
		{
			
			session.setAttribute("notavailable", "Delete Fail");
			response.sendRedirect("./deletebyid.jsp");
//			rd = request.getRequestDispatcher("./notFound.html");
//			rd.forward(request, response);
		}
		
	}

}
