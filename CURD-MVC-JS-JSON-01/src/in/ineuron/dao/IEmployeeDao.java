package in.ineuron.dao;

import in.ineuron.dto.Employee;

public interface IEmployeeDao
{
	String save(Employee employee);
	String deleteById(Integer id);
	Employee findById(Integer id);
	String updateById(Employee employee);
}
