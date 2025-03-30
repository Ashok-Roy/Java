package in.ineuron.Test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.bean.Employee;

public class TestApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// using the FileSystemResource to locate the configuration file
		FileSystemResource resource = new FileSystemResource("./src/applicationContext.xml");

		// Creating an IOC container
		XmlBeanFactory factory = new XmlBeanFactory(resource);

		// Requesting IOC container to give the Object,searching will happen in cache and if it is not found then object will created by loading and performing // setter injection.
		Employee employee = factory.getBean("emp", Employee.class);

		// using the target object performing the operation and printing the result
		System.out.println(employee);

	}
}
