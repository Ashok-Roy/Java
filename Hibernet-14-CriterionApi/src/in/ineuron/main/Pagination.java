package in.ineuron.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import in.ineuron.Model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class Pagination {
	public static void main(String[] args) {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(BankAccount.class);
			criteria.setFirstResult(1);
			criteria.setMaxResults(2);
			List<BankAccount> list = criteria.list();
			list.forEach(System.out::println); 
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession(session);
		}
	}

}
