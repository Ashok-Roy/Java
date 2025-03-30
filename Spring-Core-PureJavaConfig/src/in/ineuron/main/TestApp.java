package in.ineuron.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.ineuron.cfg.AppConfig;
import in.ineuron.comp.WishMessageGenerator;

public class TestApp {
	
	public static void main(String[] args) throws IOException {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("===============Container Started==========");
		
		System.in.read();
		WishMessageGenerator message = factory.getBean(WishMessageGenerator.class);
		String greetmessage = message.greetMessage("Nithin");
		System.out.println(greetmessage);
		
		((AbstractApplicationContext) factory).close();
		System.out.println("================Container Closed==========");
	}

}
