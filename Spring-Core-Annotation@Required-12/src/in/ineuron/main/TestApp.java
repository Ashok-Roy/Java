package in.ineuron.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.bean.Robot;

public class TestApp {
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/in/ineuron/cfg/applicationContext.xml");
		Robot robot = applicationContext.getBean("robot",Robot.class);
		System.out.println(robot);
		applicationContext.close();
		
		
	}

}
