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
				transaction = session.beginTransaction();

			if (transaction != null) {
				Employee employee = new Employee();
				employee.setEmpId(107);
				employee.setEmpName("Rayna");
				employee.setEmpSalary(130000);

				session.save(employee);
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
