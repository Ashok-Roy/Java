package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;

public class IStudentControllerImpl implements IStudentController {
	
	IStudentService studentService;
	@Override
	public String save(Student student)
	{
		studentService = StudentServiceFactory.getStudentService();
		return studentService.save(student);
		
	}

	@Override
	public Student findById(Integer sid) 
	{
		studentService = StudentServiceFactory.getStudentService();
		return studentService.findById(sid);
	}

	@Override
	public String updateById(Student student)
	{
		studentService = StudentServiceFactory.getStudentService();
		return studentService.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) 
	{
		studentService = StudentServiceFactory.getStudentService();
		return studentService.deleteById(sid);
	}

}
