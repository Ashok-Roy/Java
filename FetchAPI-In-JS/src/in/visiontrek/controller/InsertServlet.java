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


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	public void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		
		System.out.println("Control in Insert servlet");
		// Get the JSON data from the request body
		BufferedReader reader = request.getReader();
		String jsonData = reader.lines().collect(Collectors.joining());
		System.out.println("json data: " + jsonData);
		
		  
		// Convert the JSON data to an object
		Gson gson = new Gson();
		Employee newEmployeeData = gson.fromJson(jsonData, Employee.class);
		//System.out.println(newEmployeeData);
		
		
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		String status = employeeService.save(newEmployeeData);
		if(status.equalsIgnoreCase("success"))
		{
			 	response.setContentType("application/json");

			    // Write a response message
			    PrintWriter out = response.getWriter();
			    out.println("{\"message\": \"success\"}");
			 
				
		}else{
				
			response.setContentType("application/json");
			
			// Write a response message
			PrintWriter out = response.getWriter();
			out.println("{\"message\": \"Failed\"}");
			
		}
	}
}
