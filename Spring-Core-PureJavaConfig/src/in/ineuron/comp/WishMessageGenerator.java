package in.ineuron.comp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishMessageGenerator {
	static{
		System.out.println("WishMessageGenerator.class file loading...");
	}
	public WishMessageGenerator(){
		System.out.println("WishMessageGenerator zero param constructor...");
	}
	
	@Autowired
	private LocalDateTime dateTime;
	public String greetMessage(String user){
		int hour = dateTime.getHour();
		if(hour<12){
			return "Good Morning";
		}else if(hour<16){
			return "Good Afternoon";
			
		}else if(hour<20){
			return "Good Evening";
		}else{
			return "Good Night";
		}
	
	}

}
