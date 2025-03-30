package in.visiontech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.visiontech.dto.Employee;
import in.visiontech.factory.EmployeeServiceFactory;
import in.visiontech.service.IEmployeeService;

@WebServlet("/alldata")
public class AllDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		
		RequestDispatcher rd = null;
		List<Employee> newList = null;
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		newList = employeeService.employeeData();
		//System.out.println(newList);
		
		request.setAttribute("newlist", newList);

		rd = request.getRequestDispatcher("./allemployee.jsp");
		rd.forward(request, response);
		
//		String json = new Gson().toJson(newList);
//        System.out.println(json);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(json);
		
	}

}
