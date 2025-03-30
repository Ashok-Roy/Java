package in.ineuron.service;

import in.ineuron.bo.CustomerBO;
import in.ineuron.dao.ICustomerDAO;
import in.ineuron.dto.CustomerDTO;

public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	private ICustomerDAO dao;

	static {
		System.out.println("CustomerMgmtServiceImpl.class file is loading...");
	}

	public CustomerMgmtServiceImpl(ICustomerDAO dao) {
		System.out.println("CustomerMgmtServiceImpl:: One param constructor..");
		this.dao = dao;
	}

	@Override
	public String calculateSimpleInterest(CustomerDTO dto) {
		dao.insert(new CustomerBO());
		return null;
	}

}
