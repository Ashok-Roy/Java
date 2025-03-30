package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class DeleteOperation {

	public static void main(String[] args) 
	{
		Transaction transaction = null;
		boolean flag = false;
		Session session = HibernateUtil.getSession();
		try{
			if(session != null)
				transaction = session.beginTransaction();
			if(transaction != null)
			{
				int id = 107;
				Employee employee = session.get(Employee.class, id);
				if(employee != null)
				{
					session.delete(employee);
					flag = true;
				}else
				{
					System.out.println("Record Not Found ");
					return;
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}finally{
			if(flag == true){
				transaction.commit();
				System.out.println("Object Delete Successful");
			}else{
				transaction.rollback();
				System.out.println("Object Unable To Delete");
			}
		}
			
	}

}
