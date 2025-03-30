package jrout.tutorial.springbootservletjsp.service;

import jrout.tutorial.springbootservletjsp.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee getEmployee(int empId);
    List<Employee> getEmployeeList(String fname);
}
