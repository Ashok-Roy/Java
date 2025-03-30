package in.ineuron.main;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.bean.College;
import in.ineuron.bean.ContactsInfo;
import in.ineuron.bean.MarksInfo;
import in.ineuron.bean.UniversityInfo;

public class TestApp {
	
	public static void main(String[] args) 
	{
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("/in/ineuron/cfg/applicationContext.xml");
//		MarksInfo marksInfo = factory.getBean("marksInfo",  MarksInfo.class);
//		System.out.println(marksInfo);
		
//		College college = factory.getBean("college", College.class);
//		System.out.println(college);
		
//		ContactsInfo contact = factory.getBean("contact", ContactsInfo.class);
//		System.out.println(contact);
		
		UniversityInfo uniInfo = factory.getBean("uniInfo",UniversityInfo.class);
		System.out.println(uniInfo);
			
		
	}
}
