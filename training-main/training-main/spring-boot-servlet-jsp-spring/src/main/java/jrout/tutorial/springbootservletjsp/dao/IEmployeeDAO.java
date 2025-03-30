package jrout.tutorial.springbootservletjsp.dao;

import jrout.tutorial.springbootservletjsp.model.Employee;

import java.util.List;

public interface IEmployeeDAO {
    Employee getEmployee(int empId);
    List<Employee> getEmployeeList(String fname);

}
