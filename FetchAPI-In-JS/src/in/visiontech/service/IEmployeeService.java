package in.visiontech.service;

import java.util.ArrayList;

import in.visiontreck.dto.Employee;


public interface IEmployeeService
{
	String save(Employee employee); // Creating a record
	Employee findById(Integer eid); // Reading a record
	String updateById(Employee employee);// Updating a record
	String deleteById(Integer eid);// Deleting a record
	ArrayList<Employee> employeeData(); 
}
