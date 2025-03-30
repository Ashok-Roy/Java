package in.ineuron.controller;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.bean.Employee;


public class TestApp {

	public static void main(String[] args) 
	{
		// using the FileSystemResource to locate the applicationContext.xml file
		FileSystemResource resource = new FileSystemResource(".\\src\\applicationContext.xml");
		// Creating an IOC Container
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		//Requesting the IOC container to give the Object, Searching will happened in cache
		// and if it is not found then object will be created by loading and performing setter injection
		
		Employee employee = factory.getBean("emp", Employee.class);
		System.out.println(employee);
	}

}
