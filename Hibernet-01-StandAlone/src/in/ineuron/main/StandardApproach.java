package in.ineuron.main;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Employee;

public class StandardApproach {

	
	public static void main(String[] args)
	{
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		
		cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		
		Employee employee = new Employee();
		employee.setEmpId(106);
		employee.setEmpName("Padma");
		employee.setEmpSalary(15000);
		try{
			
			transaction = session.beginTransaction();
			Serializable object = session.save(employee);
			System.out.println(object);
			flag = true;
		}catch(HibernateException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(flag == true)
			{
				transaction.commit();
			}else{
				transaction.rollback();
			}
			session.close();
			sessionFactory.close();
		}
		
		
		
		
		
		
		
	}

}
