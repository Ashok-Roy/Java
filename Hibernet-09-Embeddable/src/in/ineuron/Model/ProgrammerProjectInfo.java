package in.ineuron.Model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjectInfo
{
	@Column(name="pname")
	private String  programmerName;
	@Column(name="depNo")
	private Integer deptNo;
	@Column(name="proName")
	private String  projectName;
	
	@EmbeddedId
	private ProjectInfo projectInfo;

	public ProgrammerProjectInfo()
	{
		
	}
	
	public ProgrammerProjectInfo(String programmerName, Integer deptNo, String projectName, ProjectInfo projectInfo) {
		super();
		this.programmerName = programmerName;
		this.deptNo = deptNo;
		this.projectName = projectName;
		this.projectInfo = projectInfo;
	}

	public String getProgrammerName() {
		return programmerName;
	}


	public Integer getDeptNo() {
		return deptNo;
	}



	public String getProjectName() {
		return projectName;
	}

	
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}	

}
