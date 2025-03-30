package in.ineuron.bean;

import java.util.Date;

//Target class-----> UserDefined
public class WishMessgeGenerator {

	// HAS-A relationship

	// Dependent class ---> Predefined
	private Date date;

	static {
		System.out.println("WishMessageGenerator.class file is loading...");
	}

	public WishMessgeGenerator() {
		System.out.println("WishMessageGenerato object is created...");
	}

	public WishMessgeGenerator(Date date) {
		System.out.println("CONSTRUCTOR INJECTION IS HAPPENING TO INJECT DATE OBJECT :: " + date);
		this.date = date;
	}

	public void setDate(Date date) {
		System.out.println("SETTER INJECTION IS HAPPENING TO INJECT DATE OBJECT :: " + date);
		this.date = date;
	}

	// BUISNESS logic to use Injected DATE in the Target class Object
	public String generateWishMessage(String name) {
		@SuppressWarnings("deprecation")
		int hour = date.getHours();
		if (hour <= 12)
			return "Hello :: " + name + " Good morning!!!";
		else if (hour <= 16)
			return "Hello :: " + name + " Good Afternoon!!!";
		else if (hour <= 20)
			return "Hello :: " + name + " Good Evening!!!";
		else
			return "Hello :: " + name + " Good Night!!!";
	}
}
