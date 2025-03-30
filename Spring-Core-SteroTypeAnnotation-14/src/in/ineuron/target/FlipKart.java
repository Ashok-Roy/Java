package in.ineuron.target;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import in.ineuron.comp.Courier;

// Target object 
@Component(value="fpkt")
@Scope(scopeName="prototype")  // every scan new new object
public class FlipKart {
	// Dependent object 
	@Autowired
	@Qualifier("dtdc")
	private Courier courier;
	
	static{
		System.out.println("FlipKart.calss file is loading....");
	}
	
	public FlipKart()
	{
		System.out.println("FlipKart object is created....");
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
