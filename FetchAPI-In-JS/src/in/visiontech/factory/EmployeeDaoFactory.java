package in.visiontech.factory;

import in.visiontech.dao.EmployeeDaoImpl;
import in.visiontech.dao.IEmployeeDao;

public class EmployeeDaoFactory 
{
	private static IEmployeeDao employeeDao = null;
	private EmployeeDaoFactory()
	{
		
	}
	public static IEmployeeDao getEmployeeDao()
	{
		if(employeeDao == null)
			employeeDao = new EmployeeDaoImpl();
		return employeeDao;
	}

}
