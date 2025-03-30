package in.ineuron.comp;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="dtdc")
//every scan new new object and untill unless we call object will not created 
//@Scope(scopeName="prototype") 
@Lazy
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
