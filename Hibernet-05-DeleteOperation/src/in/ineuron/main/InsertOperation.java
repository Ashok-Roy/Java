package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class InsertOperation {

	public static void main(String[] args) 
	{
		Session session = null;
		Transaction transaction = null;
		Boolean flag =false;
		try {
			session = HibernateUtil.getSession();
			if (session != null)
				transaction = session.beginTransaction(); // set auto commit false when persist

			if (transaction != null) {
				Employee employee = new Employee();
			
				employee.setEmpName("Dravid");
				employee.setEmpSalary(140000);

				session.persist(employee); // perform save operation 
				//session.save(employee);
				flag = true;
			} 
		} catch (Exception e)
		{
			e.printStackTrace();	
		}finally{
			if(flag == true)
				transaction.commit();
			else
				transaction.rollback();
			HibernateUtil.closeSession(session);	
			
		}
	}

}
