package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class DeleteOperation {

	public static void main(String[] args) 
	{
		Transaction transaction = null;
		Employee emp1 = null;
		boolean flag = false;
		Session session = HibernateUtil.getSession();
		
		try{
			Integer id = 104;
			transaction = session.beginTransaction();
			emp1 = session.get(Employee.class, id);
			if(emp1 != null)
			{
				session.delete(emp1);
				flag = true;
			}else{
				System.out.println("Record Not Found with this id :" + id);
				System.exit(0);
			}
			
		}catch(Exception h)
		{
			h.printStackTrace();
			flag = false;
		}finally{
			if(flag)
			{
				transaction.commit();
				System.out.println("Object Deleted Successful");
			}else{
				transaction.rollback();
				System.out.println("Object Deletion Failed");
			}
		}

	}

}
