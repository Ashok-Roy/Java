package in.ineuron.service;

import in.ineuron.dto.CustomerDTO;

public interface ICustomerMgntService {
	public abstract String calculateSimpleInterest(CustomerDTO dto);

}
