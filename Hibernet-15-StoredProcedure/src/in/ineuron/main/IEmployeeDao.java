package in.ineuron.main;

import java.util.List;

import in.ineuron.Model.Employee;

public interface IEmployeeDao {
	
	List<Employee> getSalaryWithinRange(int start, int end);
	String[] getEmployeeById(int id);

}
