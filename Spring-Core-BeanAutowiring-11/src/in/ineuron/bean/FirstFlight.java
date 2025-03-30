package in.ineuron.bean;

public class FirstFlight implements Courier {
	
	static{
		System.out.println("FirstFlight.class file is loading...");
	}
	
	public FirstFlight()
	{
		System.out.println("FirstFlight object is created");
	}

	@Override
	public String deliver(int oid) {
		return "First Flight courier will deliver order id :: " + oid +" order products ";
	}

}
