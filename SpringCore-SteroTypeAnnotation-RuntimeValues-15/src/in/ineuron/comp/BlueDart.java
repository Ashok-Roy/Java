package in.ineuron.comp;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="bDart")
//every scan new new object and untill unless we call object will not created 
//@Scope(scopeName="prototype") 
@Lazy
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
