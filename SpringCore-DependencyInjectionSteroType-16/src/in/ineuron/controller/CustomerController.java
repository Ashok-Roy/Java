package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgntService;
import in.ineuron.vo.CustomerVO;

@Component(value="controller")
public class CustomerController 
{
	@Autowired
	private ICustomerMgntService service;
	
	// Constructor injection 
	public CustomerController(ICustomerMgntService service)
	{
		this.service = service;
	}
	
	
	public String processResult(CustomerVO bo)
	{
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setCustomerName(bo.getCustomerName());
		customerDto.setCustomerAddress(bo.getCustomerAddress());
		customerDto.setPamt(Float.parseFloat(bo.getPamt()));
		customerDto.setRate(Float.parseFloat(bo.getRate()));
		customerDto.setTime(Float.parseFloat(bo.getTime()));
		
		System.out.println(customerDto);
		
		return service.calculateSimpleInterest(customerDto);
		 
	}

}
