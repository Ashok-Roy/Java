package in.visiontech.service;

import java.util.ArrayList;

import in.visiontech.dao.IEmployeeDao;
import in.visiontech.factory.EmployeeDaoFactory;
import in.visiontreck.dto.Employee;

public class EmployeeServiceImpl implements IEmployeeService {
	IEmployeeDao employeeDao = null;
	@Override
	public String save(Employee employee) {
		employeeDao = EmployeeDaoFactory.getEmployeeDao();
		return employeeDao.save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		employeeDao = EmployeeDaoFactory.getEmployeeDao();
		return employeeDao.findById(eid);
	}

	@Override
	public String updateById(Employee employee) {
		employeeDao = EmployeeDaoFactory.getEmployeeDao();
		return employeeDao.updateById(employee);
	}

	@Override
	public String deleteById(Integer eid) {
		employeeDao = EmployeeDaoFactory.getEmployeeDao();
		return employeeDao.deleteById(eid);
	}
	
	@Override
	public ArrayList<Employee> employeeData()
	{
		employeeDao = EmployeeDaoFactory.getEmployeeDao();
		return employeeDao.employeeData();
	}

}
