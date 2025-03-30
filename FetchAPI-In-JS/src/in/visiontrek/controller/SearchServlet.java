package in.visiontrek.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.visiontech.factory.EmployeeServiceFactory;
import in.visiontech.service.IEmployeeService;
import in.visiontreck.dto.Employee;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		
		System.out.println("Control in search servlet");
		// Get the JSON data from the request body
		BufferedReader reader = request.getReader();
		String jsonData = reader.lines().collect(Collectors.joining());
		System.out.println("json data: " + jsonData);
		
		  
		// Convert the JSON data to an object
		Gson gson = new Gson();
		Employee newEmployeeData = gson.fromJson(jsonData, Employee.class);
		//System.out.println("Employee data: "+newEmployeeData);
		//data in the console
		Integer id = newEmployeeData.getEid();
		
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		Employee data = employeeService.findById(id);
		System.out.println(data);
		if(data != null)
		{
			String json = new Gson().toJson(data);
	        //System.out.println(json);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(json);
			 
				
		}else{
				
			String json = new Gson().toJson(data);
	        //System.out.println(json);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(json);
			
		}
	}
}
