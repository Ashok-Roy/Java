package in.ineuron.service;

import in.ineuron.bo.CustomerBO;
import in.ineuron.dao.ICustomerDao;
import in.ineuron.dto.CustomerDTO;

public class CustomerMgntServiceImpl implements ICustomerMgntService {

	private ICustomerDao dao;
	
	private CustomerMgntServiceImpl(ICustomerDao dao) 
	{
		System.out.println("CustomerMgntServiceImpl.CustomerMgntServiceImpl()");
		this.dao = dao;
		
		
	}
	@Override
	public String calculateSimpleInterest(CustomerDTO dto) 
	{
		float intrAmt = 0.0f;
		intrAmt = (dto.getPamt() * dto.getTime() * dto.getRate())/100.0f;
		CustomerBO bo = new CustomerBO();
		bo.setCustomerAddress(dto.getCustomerAddress());
		bo.setCustomerName(dto.getCustomerName());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setInterestAmt(intrAmt);
		
			
		
		
		
		int row = dao.insert(bo);
		if(row != 0)
			return "success";
		return "Failed";
	}

}
