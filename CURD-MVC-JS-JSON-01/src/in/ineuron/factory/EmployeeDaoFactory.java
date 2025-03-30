package in.ineuron.factory;

import in.ineuron.dao.EmployeeDaoImpl;
import in.ineuron.dao.IEmployeeDao;

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
