package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class UpdateOperation 
{
	public static void main(String[] args) 
	{
		Transaction transaction = null;
		boolean flag = false; // Make sure to use in write place 
		Session session = HibernateUtil.getSession();
		
		Employee employee = new Employee();
		employee.setEmpId(101);
		employee.setEmpName("Nitin");
		employee.setEmpSalary(140000);
				
		try{
			transaction = session.beginTransaction();
			session.update(employee);
			flag = true;
		}catch(HibernateException e)
		{
			flag= false;
			e.printStackTrace();
		}finally{
			if(flag)
				transaction.commit();
			else
				transaction.rollback();
		}
	}
}
