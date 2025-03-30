package in.ineuron.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="branch")
public class Branch {
	
	@Id
	private String branchId;
	private String branchName;
	private String branchLocation;
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchLocation() {
		return branchLocation;
	}
	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", branchLocation=" + branchLocation
				+ "]";
	}
	
	
	
}
