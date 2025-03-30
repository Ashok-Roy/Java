package in.ineuron.factory;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.IStudentDaoImpl;

public class StudentDaoFactory
{
	private static IStudentDao studentDao = null;
	private StudentDaoFactory()
	{
		
	}
	
	public static IStudentDao getStudentDao()
	{
		if (studentDao == null) 
			studentDao = new IStudentDaoImpl();
		
		return studentDao;
			
	}

}
