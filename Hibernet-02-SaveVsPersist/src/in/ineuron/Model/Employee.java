package in.ineuron.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empTable")
public class Employee 
{
	@Id
	@Column(name="eid")
	// Persist will not work with Generators
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
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
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

	
}
