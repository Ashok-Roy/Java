package in.ineuron.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.bean.PersonInfo;

public class ClientApp {

	public static void main(String[] args) 
	{
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("/in/ineuron/cfg/applicationContext.xml");
		
		PersonInfo person1 = factory.getBean("person1", PersonInfo.class);
		System.out.println(person1);
		System.out.println();
		PersonInfo person2 = factory.getBean("person2", PersonInfo.class);
		System.out.println(person2);
		
		
	}

}
