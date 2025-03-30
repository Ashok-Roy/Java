package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class SaveOrUpdate {

	public static void main(String[] args) 
	{
		Transaction transaction = null;
		boolean flag = false;
		Session session = HibernateUtil.getSession();
		Employee employee = new Employee();
		employee.setEmpId(103);
		employee.setEmpName("Navin Sir");
		employee.setEmpSalary(160000);
		
		try{
			transaction = session.beginTransaction();
			session.saveOrUpdate(employee);
			flag = true;
		}catch(HibernateException h)
		{
			flag = false;
			h.printStackTrace();
		}finally{
			if(flag){
				
				transaction.commit();
				System.out.println("Update/Save Successful");
			}
			else{
				transaction.rollback();
				System.out.println("Update/Save failed");
			}
		}
		

	}

}
