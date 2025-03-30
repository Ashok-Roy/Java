package in.ineuron.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.bean.FlipKart;

public class TestApp {
	public static void main(String[] args) 
	{
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("/in/ineuron/cfg/applicationContext.xml");
		
		FlipKart fpkt = factory.getBean("fpkt", FlipKart.class);
		String result = fpkt.shopping(new String[]{"Iphone","Bike","House"},
				new float[]{1200.0f, 1300.0f, 5500.0f });
		
		System.out.println(result);
	}

}
