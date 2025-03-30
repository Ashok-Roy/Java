package in.ineuron.bean;

import java.util.Date;
import java.util.Set;

public class ContactsInfo 
{
	private Set<Long> phoneNumber;
	private Set<Date> dates;
	
	
	public ContactsInfo(Set<Long> phoneNumber, Set<Date> dates)
	{
		System.out.println("ContactsInfo.ContactsInfo()");
		this.phoneNumber = phoneNumber;
		this.dates = dates;
	}


	@Override
	public String toString() {
		return "ContactsInfo [phoneNumber=" + phoneNumber + ", dates=" + dates + "]";
	}
	
	

}
