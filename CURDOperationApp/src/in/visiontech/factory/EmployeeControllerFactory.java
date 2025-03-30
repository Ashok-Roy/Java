package in.visiontech.factory;

import in.visiontech.controller.EmployeeControllerImpl;
import in.visiontech.controller.IEmployeeController;

public class EmployeeControllerFactory 
{
	private static IEmployeeController employeeController = null;
	private EmployeeControllerFactory()
	{
		
	}
	public static IEmployeeController getEmployeeController()
	{
		if(employeeController == null)
			employeeController = new EmployeeControllerImpl();
		return employeeController;
	}

}
