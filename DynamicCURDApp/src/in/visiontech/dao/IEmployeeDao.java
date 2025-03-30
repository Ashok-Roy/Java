package in.visiontech.dao;

import java.util.ArrayList;

import in.visiontech.dto.Employee;

public interface IEmployeeDao 
{
	String save(Employee save); // Creating a record
	Employee findById(Integer eid); // Reading a record
	String updateById(Employee employee);// Updating a record
	String deleteById(Integer eid);// Deleting a record
	ArrayList<Employee> employeeData();

}
