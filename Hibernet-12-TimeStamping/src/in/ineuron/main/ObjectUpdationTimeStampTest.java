package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class ObjectUpdationTimeStampTest {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag =false;
		BankAccount account=null;
		session = HibernateUtil.getSession();
		
	
		try{
			transaction = session.beginTransaction();
			account = session.get(BankAccount.class, 2L);
			System.out.println("Account is " + account);
			if(account!=null)
			{
				account.setBalance(account.getBalance()+87734.0);
				flag=true;
			}else{
				System.out.println("Account Not Found!");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}finally{
			if(flag)
			{
				transaction.commit();
				System.out.println("Account is open on "+ account.getOpeningDate());
				System.out.println("Account is modified on "+ account.getLastUpdate());
			}else{
				transaction.rollback();
				System.out.println("Object is not saved");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
