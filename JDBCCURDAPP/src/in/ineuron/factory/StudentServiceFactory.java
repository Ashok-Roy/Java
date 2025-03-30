package in.ineuron.factory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.IStudentServiceImpl;

public class StudentServiceFactory 
{
	private static IStudentService studentService = null;
	
	private StudentServiceFactory()
	{
		
	}
	
	public static IStudentService getStudentService()
	{
		if (studentService == null) 
			studentService = new IStudentServiceImpl();
		return studentService;
		
	}
}
