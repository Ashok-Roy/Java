package in.ineuron.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.bean.A;
import in.ineuron.bean.B;


public class TestApp {

	public static void main(String[] args) 
	{
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("/in/ineuron/cfg/applicationContext.xml");
		
		A a = factory.getBean("a1",A.class);
		System.out.println(a);
		
		B b = factory.getBean("b1", B.class);
		System.out.println(b);
		
		
		// 
		
		
		
	}

}
