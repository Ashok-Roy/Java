package in.ineuron.comp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="fFlight")
//every scan new new object and untill unless we call object will not created 
//@Scope(scopeName="prototype") 
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
