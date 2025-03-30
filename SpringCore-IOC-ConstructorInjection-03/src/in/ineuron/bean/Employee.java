package in.ineuron.bean;

public class Employee {
	private Integer eno;
	private String ename;
	private Float esalary;
	
	public Employee(Integer eno, String ename, Float esalary) {
		this.eno = eno;
		this.ename = ename;
		this.esalary = esalary;
	}
	
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", esalary=" + esalary + "]";
	}
	
	

}
