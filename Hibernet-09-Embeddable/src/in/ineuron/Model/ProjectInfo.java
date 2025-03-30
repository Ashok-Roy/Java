package in.ineuron.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjectInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="pid")
	private Integer pid;
	@Column(name="pmgId")
	private Integer pmgId;

	public ProjectInfo(Integer pid, Integer pmgId) {
		super();
		this.pid = pid;
		this.pmgId = pmgId;
	}
	public Integer getPid() {
		return pid;
	}
	public Integer getPmgId() {
		return pmgId;
	}
	
	 	
	

}
