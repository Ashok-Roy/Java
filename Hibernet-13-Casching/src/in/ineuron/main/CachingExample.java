package in.ineuron.main;

import org.hibernate.Session;

import in.ineuron.Model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class CachingExample {
	public static void main(String[] args) {
		Session session = null;
		boolean flag = false;
		session = HibernateUtil.getSession();
		BankAccount bankData = new BankAccount();
		
		try{
			bankData = session.get(BankAccount.class, 1L);
			System.out.println("Balance is " + bankData.getBalance());
			System.out.println("Balance is :" + bankData.getBalance());
			session.evict(bankData); // To remove object from L1 cash
			bankData = session.get(BankAccount.class, 1L);
			System.out.println("Balance is :" + bankData.getBalance());
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}finally{
			if(flag)
			{
				System.out.println("Object is saved");
			}else{
				System.out.println("Object is not saved");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
