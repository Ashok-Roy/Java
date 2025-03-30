package in.ineuron.bean;

import java.util.Date;
import java.util.List;

public class College {
	private List<String> nameList;
	private List<Date> date;
	public List<String> getNameList() {
		return nameList;
	}
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
	public List<Date> getDate() {
		return date;
	}
	public void setDate(List<Date> date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "College [nameList=" + nameList + ", date=" + date + "]";
	}
	
}
