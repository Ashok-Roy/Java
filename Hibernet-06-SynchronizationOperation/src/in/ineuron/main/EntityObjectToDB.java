package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class EntityObjectToDB {

	public static void main(String[] args)
	{
		Transaction transaction = null;
		Employee employee  = null;
		boolean flag = false;
		Session session = HibernateUtil.getSession();
		
		try{
			Integer id = 103;
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, id);
			if(employee != null)
			{
				System.out.println(" Old Employee : " + employee);
				System.out.println("Changing Doing.....");
				employee.setEmpName("Navin Reddy");
				employee.setEmpSalary(2000000);
				flag = true;
				
			}else{
				System.out.println("Record Not Found!");
				System.exit(0);
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}finally{
			if(flag)
			{
				transaction.commit();
				System.out.println("Update/Changes Happened in DB");
			}else{
				transaction.rollback();
				System.out.println("Update/Changes Not Perform");
			}
		}
	}

}
