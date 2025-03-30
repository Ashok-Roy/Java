package in.ineuron.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.bean.FlipKart;

public class TestApp {
	public static void main(String[] args) 
	{

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/in/ineuron/cfg/applicationContext.xml");
		FlipKart fpkt = applicationContext.getBean("fpkt", FlipKart.class);
		
		String result = fpkt.shopping(new String[]{"Iphone","Bike","House"},
				new float[]{1200.0f, 1300.0f, 5500.0f });
		
		System.out.println(result);
	}

}
