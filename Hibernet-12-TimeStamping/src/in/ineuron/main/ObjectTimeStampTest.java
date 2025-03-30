package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class ObjectTimeStampTest {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		
		Long idValue= null;
		boolean flag = false;
		session = HibernateUtil.getSession();
		BankAccount account = new BankAccount();
		account.setHolderName("Sachin");
		account.setBalance(18984.0);
		account.setType("Saving");
		try{
			transaction = session.beginTransaction();
			idValue = (Long)session.save(account);
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}finally{
			if(flag)
			{
				transaction.commit();
				System.out.println("Object is saved");
			}else{
				transaction.rollback();
				System.out.println("Object is not saved");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
