package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class GeneratorApp {
// Check the console correctly 
	public static void main(String[] args)
	{
		Transaction transaction = null;
		boolean flag = false;
		Session session = HibernateUtil.getSession();
		Employee employee = new Employee();
		
		
		employee.setEmpName("Sanggakara");
		employee.setEmpSalary(12000);
		try{
			transaction = session.beginTransaction();
			session.save(employee);
			flag = true;
		}catch(HibernateException e)
		{
			e.printStackTrace();
		}finally{
			if(flag)
			{
				transaction.commit();
				System.out.println("Insertion Successful...");
			}else{
				transaction.rollback();
				System.out.println("Insertion Failed");
			}
		}
	}

}
