package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class LoadAndUpdateOperation 
{
	public static void main(String[] args) 
	{
		Transaction transaction = null;
		Employee employee = null;
		boolean flag = false; // Make sure to use in write place 
		Session session = HibernateUtil.getSession();
		
		
		try{
			int id = 101;
			employee = session.get(Employee.class, id);
			if(employee != null)
			{				
				employee.setEmpName("Nitin");
				employee.setEmpSalary(150000);
				transaction = session.beginTransaction();
				session.update(employee);
				flag = true;
			}else{
				System.out.println("Record Not Found!");
				System.exit(0);
			}
		}catch(HibernateException e)
		{
			flag= false;
			e.printStackTrace();
		}finally{
			if(flag){
				transaction.commit();
				System.out.println("Record Updated");
			}
			else
				transaction.rollback();
		}
	}
}
