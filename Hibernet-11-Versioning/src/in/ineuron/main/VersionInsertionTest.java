package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class VersionInsertionTest {
// Check the console correctly 
	public static void main(String[] args)
	{
		Transaction transaction = null;
		boolean flag = false;
		Session session = HibernateUtil.getSession();
		MobileCustomer customer = new MobileCustomer();
		
		
		customer.setcName("Sachin");
		customer.setMobileNumber(8733438);
		customer.setCollerTune("KGF-2");
		try{
			transaction = session.beginTransaction();
			session.save(customer);
			flag = true;
		}catch(HibernateException e)
		{
			e.printStackTrace();
		}finally{
			if(flag)
			{
				transaction.commit();
				System.out.println("Insertion Successful...");
			}else{
				transaction.rollback();
				System.out.println("Insertion Failed");
			}
		}
	}

}
