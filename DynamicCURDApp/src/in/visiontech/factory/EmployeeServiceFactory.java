package in.visiontech.factory;

import in.visiontech.service.EmployeeServiceImpl;
import in.visiontech.service.IEmployeeService;

public class EmployeeServiceFactory
{
	private static IEmployeeService employeeService = null;
	private EmployeeServiceFactory()
	{
		
	}
	public static IEmployeeService getEmployeeService()
	{
		if(employeeService == null)
			employeeService = new EmployeeServiceImpl();
		return employeeService;
	}

}
