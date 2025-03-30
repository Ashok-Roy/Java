package in.ineuron.controller;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.bean.WishMessageGenerator;

public class TestApp {

	public static void main(String[] args) 
	{
		// using the FileSystemResource to locate the applicationContext.xml file
		FileSystemResource resource = new FileSystemResource(".\\src\\applicationContext.xml");
		// Creating an IOC Container
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		//Requesting the IOC container to give the Object, Searching will happened in cache
		// and if it is not found then object will be created by loading and performing setter injection
		WishMessageGenerator generator1 =  factory.getBean("wmg", WishMessageGenerator.class);
		
		// using the target object performing the operation and printing the result
		String message = generator1.wishMessageGenerator("sachin");
		System.out.println(message);
		
	}

}
