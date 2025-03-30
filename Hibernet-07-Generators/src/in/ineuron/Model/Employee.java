package in.ineuron.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employee")
public class Employee 
{
	/*
	 * Eid is indeed, we have to assign the eid 
	 * Assigned 
	@Id
	@Column(name="eid")
	@GenericGenerator(name="gen1",  strategy ="assigned")
	@GeneratedValue(generator = "gen1")
	private Integer empId;*/
	
	/*
	 * No need to supply the eid it will auto increment in main class 
	 * Increment
	@Id
	@Column(name="eid")
	@GenericGenerator(name="gen1",  strategy ="increment")
	@GeneratedValue(generator = "gen1")
	private Integer empId;*/
	
	
	// Identity 
	@Id
	@Column(name="eid")
	@GenericGenerator(name="gen1",  strategy ="identity")
	@GeneratedValue(generator = "gen1")
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
	public String getEmpName() {
		return empName;
	}
	public Integer getEmpSalary() {
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
