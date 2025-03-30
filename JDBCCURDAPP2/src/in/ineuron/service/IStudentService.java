package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService
{
	String save(Student student);
	Student findById(Integer id);
	String updateById(Student student);
	String deleteById(Integer id);

}
