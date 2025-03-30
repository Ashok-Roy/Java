package in.ineuron.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name="customer")
public class MobileCustomer implements Serializable
{
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name ="cno")
	private Integer cNo;
	
	@Column(name="cname")
	private String cName;
	
	@Column(name="cMobileNumber")
	private Integer mobileNumber;
	
	@Column(name="collerTune")
	private String collerTune;
	
	@Version
	private Integer versionCount;
	
	static{
		System.out.println("Customer Class Is Loading....");
	}
	public MobileCustomer()
	{
		System.out.println("Hibernet is using zero parameterise constructor Employee Class");
	}
	public Integer getcNo() {
		return cNo;
	}
	public void setcNo(Integer cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCollerTune() {
		return collerTune;
	}
	public void setCollerTune(String collerTune) {
		this.collerTune = collerTune;
	}
	public Integer getVersionCount() {
		return versionCount;
	}
	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}
	@Override
	public String toString() {
		return "MobileCustomer [cNo=" + cNo + ", cName=" + cName + ", mobileNumber=" + mobileNumber + ", collerTune="
				+ collerTune + ", versionCount=" + versionCount + "]";
	}
	
}
