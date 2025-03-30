package in.ineuron.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	private Integer eid;
	private String ename;
	private Integer esalary;
	@Version
	private Integer updateCount;
	
	public Integer getUpdateCount() {
		return updateCount;
	}
	public void setUpdateCount(Integer updateCount) {
		this.updateCount = updateCount;
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
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + "]";
	}

}
