package in.ineuron.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.Model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectOperationQBC {
	public static void main(String[] args) {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<BankAccount> cquery =  criteriaBuilder.createQuery(BankAccount.class);
			Root<BankAccount> root = cquery.from(BankAccount.class);
			cquery.select(root);
			Query<BankAccount> query = session.createQuery(cquery);
			List<BankAccount> list = query.getResultList();
			list.forEach(System.out::println);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession(session);
		}
	}

}
