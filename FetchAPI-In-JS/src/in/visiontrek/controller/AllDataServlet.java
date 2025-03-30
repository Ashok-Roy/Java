package in.visiontrek.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.visiontech.factory.EmployeeServiceFactory;
import in.visiontech.service.IEmployeeService;
import in.visiontreck.dto.Employee;

@WebServlet("/AllDataServlet")
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
		//System.out.println("Control is here");
		List<Employee> newList = null;
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		newList = employeeService.employeeData();
		//System.out.println(newList);

        String json = new Gson().toJson(newList);
        //System.out.println(json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
		
	}

}
