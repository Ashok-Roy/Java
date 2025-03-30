package in.ineuron.main;

import java.util.List;

import in.ineuron.Model.Employee;

public class StoredProcedure {
	public static void main(String[] args) {
		
		IEmployeeDao employee = null;
		employee = new EmployeeImpl();
		List<Employee> list = employee.getSalaryWithinRange(1200, 20000);
		list.forEach(System.out::println);
		String[] result = employee.getEmployeeById(101);
		System.out.println("Name----" +result[0]+"  Salary--"+result[1]);
		
		
		
	}

}
