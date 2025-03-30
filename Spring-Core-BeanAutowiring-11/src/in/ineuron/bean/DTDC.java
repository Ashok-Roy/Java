package in.ineuron.bean;

public class DTDC implements Courier {
	
	static{
		System.out.println("DTDC.class file is loading...");
	}
	
	public DTDC()
	{
		System.out.println("DTDC object is created...");
	}

	@Override
	public String deliver(int oid) {
		return "DTDC courier will deliver order id :: " + oid +" order products ";
	}

}
