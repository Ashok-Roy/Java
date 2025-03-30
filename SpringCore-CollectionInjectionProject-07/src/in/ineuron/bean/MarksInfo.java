package in.ineuron.bean;

import java.util.Arrays;
import java.util.Date;

public class MarksInfo
{
	private int marks[];
	private Date dates[];
	
	static{
		System.out.println("MarksInfo.class file loading...");
	}
	
	public MarksInfo()
	{
		System.out.println("MarksInfo object create using zero arg....");
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public Date[] getDates() {
		return dates;
	}

	public void setDates(Date[] dates) {
		this.dates = dates;
	}

	@Override
	public String toString() {
		return "MarksInfo [marks=" + Arrays.toString(marks) + ", dates=" + Arrays.toString(dates) + "]";
	}

	
	

}
