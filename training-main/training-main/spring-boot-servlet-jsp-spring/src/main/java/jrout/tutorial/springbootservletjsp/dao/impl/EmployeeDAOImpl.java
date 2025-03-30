package jrout.tutorial.springbootservletjsp.dao.impl;

import jrout.tutorial.springbootservletjsp.dao.IEmployeeDAO;
import jrout.tutorial.springbootservletjsp.model.Employee;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EmployeeDAOImpl implements IEmployeeDAO {

    private static Map<String , Employee> employeeMap = new HashMap<String, Employee>();
    static {
       employeeMap.put("100", new Employee(100,"Peter"));
       employeeMap.put("101", new Employee(101,"Sam")) ;
       employeeMap.put("102", new Employee(102,"Ben")) ;
       employeeMap.put("103", new Employee(103,"Rod","Lemen")) ;
       employeeMap.put("104", new Employee(104,"Rod", "Johnson")) ;
    }

    @Override
    public Employee getEmployee(int empId) {
        return employeeMap.get(String.valueOf(empId));
    }

    @Override
    public List<Employee> getEmployeeList(String fname) {
        List<Employee> collect = employeeMap.values().stream()
                .filter(obj -> obj.getFname().equalsIgnoreCase(fname))
                .collect(Collectors.toList());
        return collect;
    }
}
