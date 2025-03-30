package in.ineuron.factory;

import in.ineuron.service.EmployeeServiceImpl;
import in.ineuron.service.IEmployeeService;

public class EmployeeServiceFactory 
{
	private static IEmployeeService employeeService = null;
	private EmployeeServiceFactory(){
	}
	public static IEmployeeService getEmployeeService()
	{
		if(employeeService == null)
			employeeService = new EmployeeServiceImpl();
		return employeeService;		
	}
}
