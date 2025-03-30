package in.ineuron.bean;

import java.util.Arrays;
import java.util.Random;

// Target object 
public class FlipKart {
	// Dependent object 
	private Courier courier;
	
	static{
		System.out.println("FlipKart.calss file is loading....");
	}
	
	public FlipKart()
	{
		System.out.println("FlipKart object is created....");
	}
	
	public FlipKart(Courier courier) 
	{
		System.out.println("Courier object is injected through constructor ");
		this.courier = courier;
	}
	
	public void setCourier(Courier courier) {
		System.out.println("Courier object is injected through setter ");
		this.courier = courier;
	}

	public String shopping(String[] items, float[] prices)
	{
		System.out.println(courier.getClass().getName());
		Random random = null;
		float billAmount = 0.0f;
		int oid = 0;
		for(float price : prices)
		{
			billAmount += price;
			
		}
		random = new Random();
		oid = random.nextInt(1000);
		String msg = courier.deliver(oid);
		
		return Arrays.toString(items) + " are purches having prices " + Arrays.toString(prices)
		+" with the bill amount : : " + billAmount+"-----> "+ msg;
	}

}
