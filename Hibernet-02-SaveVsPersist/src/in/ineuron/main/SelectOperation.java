package in.ineuron.main;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectOperation {

	public static void main(String[] args)
	{
		Session session = null;
		int id = 101;
		Employee employee = new Employee();
		try {
			session = HibernateUtil.getSession();
			if(session != null)
				employee = session.load(Employee.class, id);
			System.out.println(employee);
			

		} catch (HibernateException e) {
			
			System.out.println("Record Not Found");
		}finally{
			HibernateUtil.closeSession(session);
		}
	}

}
