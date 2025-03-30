package in.ineuron.bean;

public class BlueDart implements Courier {
	static{
		System.out.println("BlueDart.class file is loading...");
	}
	
	public BlueDart()
	{
		System.out.println("BlueDart object is created...");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");
		
		return "Blue Dart courier will deliver order id :: " + oid +" order products ";
	}

}
