package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Account;
import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class OneToOneMapping {
	public static void main(String[] args) {
		
		
		Session session = HibernateUtil.getSession();
		Transaction transaction =null;
		boolean flag = false;
		try{
			transaction = session.beginTransaction();
				
			// Dependent object
			Account account = new Account();
			account.setAccName("Dhoni");
			account.setAccNo("IN0981");
			account.setAccType("Saving");
			
			// Targeted object
			Employee employee = new Employee();
			employee.setAccount(account);
			employee.setEaddress("CSK");
			employee.setEname("Dhoni");
			employee.setEsalary(90000);
			
			
			session.save(employee);
			flag=true;
				
			
		}catch(HibernateException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(flag){
				transaction.commit();
				System.out.println("Object saved");
			}else{
				transaction.rollback();
				System.out.println("Object not saved");
			}
			
			HibernateUtil.closeSession(session);
		}
		
	}

}	
