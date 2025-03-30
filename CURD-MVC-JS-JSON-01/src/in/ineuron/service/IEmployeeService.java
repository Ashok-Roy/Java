package in.ineuron.service;

import in.ineuron.dto.Employee;

public interface IEmployeeService
{
	String save(Employee employee);
	String deleteById(Integer id);
	Employee findById(Integer id);
	String updateById(Employee employee);

}
