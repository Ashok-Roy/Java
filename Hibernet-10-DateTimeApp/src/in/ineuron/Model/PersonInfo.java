package in.ineuron.Model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PersonInfo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pid")
	private Integer pid;
	@Column(name="pname")
	private String pname;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dob;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dom;
	@Temporal(TemporalType.TIME)
	private LocalTime doj;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDateTime getDom() {
		return dom;
	}
	public void setDom(LocalDateTime dom) {
		this.dom = dom;
	}
	public LocalTime getDoj() {
		return doj;
	}
	public void setDoj(LocalTime doj) {
		this.doj = doj;
	}
	
	
	
	
	
	
	
	

	
		
	

}
