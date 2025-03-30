package in.visiontech.controller;

import in.visiontech.dto.Employee;
import in.visiontech.factory.EmployeeServiceFactory;
import in.visiontech.service.IEmployeeService;

public class EmployeeControllerImpl implements IEmployeeController {
	IEmployeeService employeeService = null;
	@Override
	public String save(Employee employee) 
	{
		employeeService = EmployeeServiceFactory.getEmployeeService();
		return employeeService.save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		employeeService = EmployeeServiceFactory.getEmployeeService();
		return employeeService.findById(eid);
	}

	@Override
	public String updateById(Employee employee) {
		employeeService = EmployeeServiceFactory.getEmployeeService();
		return employeeService.updateById(employee);
	}

	@Override
	public String deleteById(Integer eid) {
		employeeService = EmployeeServiceFactory.getEmployeeService();
		return employeeService.deleteById(eid);
	}

}
