package in.ineuron.factory;

import in.ineuron.controller.IStudentController;
import in.ineuron.controller.IStudentControllerImpl;

public class StudentControllerFactory
{
	
	private static IStudentController studentController = null;
	
	private StudentControllerFactory()
	{
		
	}
	public static IStudentController getStudentController()
	{
		if(studentController == null)
			studentController = new IStudentControllerImpl();
		return studentController;
	}

}
