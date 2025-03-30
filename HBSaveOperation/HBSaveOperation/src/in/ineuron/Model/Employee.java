package in.ineuron.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empTab")
public class Employee {
	@Id
	@Column(name = "eid")
	private Integer empId;

	@Column(name = "ename", length = 20)
	private String empName;

	@Column(name = "esal")
	private Double empSal;

	static {
		System.out.println("Employee.class is loading...");
	}

	public Employee() {
		System.out.println("Zero parameter consturctor is used by Hibernate....");
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
		System.out.println("Employee.setEmpId()");
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
		System.out.println("Employee.setEmpName()");
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
		System.out.println("Employee.setEmpSal()");
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

}
