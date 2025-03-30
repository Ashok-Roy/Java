package in.ineuron.main;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectOperationUsingGet {

	public static void main(String[] args)
	{
		Session session = null;
		int id = 101;
		Employee employee = new Employee();
		try {
			session = HibernateUtil.getSession();
			if(session != null)
				employee = session.get(Employee.class, id);
			if(employee != null)
				System.out.println(employee);
			else
				System.out.println("Employee Not Found..." + id);
			

		} catch (HibernateException e) {
			
			System.out.println("Record Not Found");
		}finally{
			HibernateUtil.closeSession(session);
		}
	}

}
