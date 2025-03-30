package in.ineuron.bean;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class UniversityInfo 
{
	private Map<Integer, String> faculatyDetails;
	private Map<String, Date> dateInfo;
	private Properties technology;
	
	
	public Map<Integer, String> getFaculatyDetails() {
		return faculatyDetails;
	}
	public void setFaculatyDetails(Map<Integer, String> faculatyDetails) {
		this.faculatyDetails = faculatyDetails;
	}
	public Map<String, Date> getDateInfo() {
		return dateInfo;
	}
	public void setDateInfo(Map<String, Date> dateInfo) {
		this.dateInfo = dateInfo;
	}
	
	
	
	public Properties getTechnology() {
		return technology;
	}
	public void setTechnology(Properties technology) {
		this.technology = technology;
	}
	@Override
	public String toString() {
		return "UniversityInfo [faculatyDetails=" + faculatyDetails + ", dateInfo=" + dateInfo + ", technology="
				+ technology + "]";
	}
	
}
