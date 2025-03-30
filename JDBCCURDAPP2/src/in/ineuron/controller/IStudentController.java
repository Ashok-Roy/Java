package in.ineuron.controller;

import in.ineuron.dto.Student;

public interface IStudentController
{
	String save(Student student);
	Student findById(Integer id);
	String updateById(Student student);
	String deleteById(Integer id);

}
