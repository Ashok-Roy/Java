package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class UpdateOperation {
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = false;
		
		try{
			if(session != null)
				transaction = session.beginTransaction();
			if(transaction != null)
			{
				Employee employee = new Employee();
				employee.setEmpId(106);
				employee.setEmpName("Padma Thinles");
				employee.setEmpSalary(150000);
				
				session.saveOrUpdate(employee);
				flag = true;
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			if(flag == true){
				transaction.commit();
				System.out.println("Updation Successful");
			}
			else{
				transaction.rollback();
				System.out.println("Updation Not Successful");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
