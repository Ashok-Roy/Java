package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;

public class StudentControllerImpl implements IStudentController {
	IStudentService studentService = null;
	@Override
	public String save(Student student) 
	{
		studentService = StudentServiceFactory.getStudentService();
		return studentService.save(student);
		
	}

	@Override
	public Student findById(Integer id) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.findById(id);
	}

	@Override
	public String updateById(Student student) {
		return null;
	}

	@Override
	public String deleteById(Integer id) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.deleteById(id);
	}

}
