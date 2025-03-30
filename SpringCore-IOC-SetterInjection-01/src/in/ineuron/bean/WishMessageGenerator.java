package in.ineuron.bean;

import java.util.Date;

// Target Class 
public class WishMessageGenerator
{
	// Dependent Object 
	private Date date;
	
	static{
		System.out.println("WishMessageGenerator.class file is loading...");
	}
	
	public WishMessageGenerator()
	{
		System.out.println("WishMessageGenerator object is instantiated....");
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		System.out.println("Setter Injection is happen to inject date object");
		this.date = date;
	}

	@Override
	public String toString() {
		return "WishMessageGenerator [Date=" + date + "]";
	}
	
	// Bussiness logic to use injected date in the target class object 
	public String wishMessageGenerator(String name)
	{
		@SuppressWarnings("deprication")
		int hour = date.getHours();
		if(hour <= 12){
			return "Hello "+ name + " Good Morning";
		}else if(hour <= 16)
		{
			return "Hello " + name + " Good Afternoon";
		}else if(hour <= 20)
		{
			return "Hello " + name + " Good Evening";
		}else{
			return "Good Night";
		}

	}
}
