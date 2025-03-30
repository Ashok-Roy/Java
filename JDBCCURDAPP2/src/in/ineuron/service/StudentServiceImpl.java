package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao = null;
	@Override
	public String save(Student student) 
	{
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.save(student);
	}

	@Override
	public Student findById(Integer id) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.findById(id);
	}

	@Override
	public String updateById(Student student) {
		return null;
	}

	@Override
	public String deleteById(Integer id) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(id);
	}

}
