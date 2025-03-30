package in.ineuron.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.bean.Car;

public class ClientApp {

	public static void main(String[] args) 
	{
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("/in/ineuron/cfg/applicationContext.xml");
		
		Car car1 = factory.getBean("car1", Car.class);
		System.out.println(car1);
		System.out.println();
		Car car2 = factory.getBean("car2", Car.class);
		System.out.println(car2);
		
		
	}

}
