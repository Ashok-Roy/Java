package in.ineuron.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="bankAccount")
public class BankAccount implements Serializable
{
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long accNo;
	private String holderName;
	private double balance;
	private String type;
	@CreationTimestamp
	private LocalDateTime openingDate;
	@UpdateTimestamp	
	private LocalDateTime lastUpdate;
	@Version
	private Integer version;
	
	
	
	public Long getAccNo() {
		return accNo;
	}



	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}



	public String getHolderName() {
		return holderName;
	}



	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public LocalDateTime getOpeningDate() {
		return openingDate;
	}



	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}



	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}



	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}



	public Integer getVersion() {
		return version;
	}



	public void setVersion(Integer version) {
		this.version = version;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", holderName=" + holderName + ", balance=" + balance + ", type=" + type
				+ ", openingDate=" + openingDate + ", lastUpdate=" + lastUpdate + ", version=" + version + "]";
	}
	
	
	
	
}
