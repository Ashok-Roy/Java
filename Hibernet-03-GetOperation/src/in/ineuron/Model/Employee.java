package in.ineuron.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="eid")
	private Integer empId;
	
	@Column(name="ename")
	private String empName;
	
	@Column(name="esalary")
	private Integer empSalary;
	
	static{
		System.out.println("Employee Class Is Loading....");
	}
	public Employee()
	{
		System.out.println("Hibernet is using zero parameterise constructor Employee Class");
	}
	
	
	public Integer getEmpId() {
		System.out.println("Employee.getId()");
		return empId;
	}
	public String getEmpName() {
		System.out.println("Employee.getEmpName()");
		return empName;
	}
	public Integer getEmpSalary() {
		System.out.println("Employee.getEmpSalary()");
		return empSalary;
	}
	public void setEmpId(Integer empId) {
		System.out.println("Employee.setId()");
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		System.out.println("Employee.setEmpName()");
		this.empName = empName;
	}
	public void setEmpSalary(Integer empSalary) {
		System.out.println("Employee.setEmpSalary()");
		this.empSalary = empSalary;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

	
}
