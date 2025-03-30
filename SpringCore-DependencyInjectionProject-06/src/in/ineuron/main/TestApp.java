package in.ineuron.main;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.controller.CustomerController;
import in.ineuron.service.ICustomerMgntService;
import in.ineuron.vo.CustomerVO;

public class TestApp {
	ICustomerMgntService service;
	
	public static void main(String[] args) {
	
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Customer Name: ");
		String customerName = scanner.next();
		 	
		System.out.println("Enter the Customer Addr: ");
		String addr = scanner.next();
		System.out.println("Enter the Principle amount: ");
		String pamount = scanner.next();
		System.out.println("Enter the Time period: ");
		String time = scanner.next();
		System.out.println("Enter the Rate: ");
		String rate = scanner.next();
		
		CustomerVO vo = new CustomerVO();
		vo.setCustomerAddress(addr);
		vo.setCustomerName(customerName);
		vo.setPamt(pamount);
		vo.setRate(rate);
		vo.setTime(time);
		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("/in/ineuron/cfg/applicationContext.xml");
		
		CustomerController controller = factory.getBean("controller", CustomerController.class);
		String result = controller.processResult(vo);
		
		System.out.println(result);
	}
}
