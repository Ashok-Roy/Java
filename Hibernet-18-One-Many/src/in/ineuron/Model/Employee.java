package in.ineuron.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer eid;
	private String ename;
	private Integer esalary;
	private String eaddress;
	
	public Employee(){
		
	}
	
	
	public Employee(String ename, Integer esalary, String eaddress) {
		this.ename = ename;
		this.esalary = esalary;
		this.eaddress = eaddress;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getEsalary() {
		return esalary;
	}
	public void setEsalary(Integer esalary) {
		this.esalary = esalary;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", eaddress=" + eaddress + "]";
	}
	
}
