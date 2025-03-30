package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class SaveOperationApp {
	public static void main(String[] args) {
		
		Session session =null;
		Transaction transaction = null;
		boolean flag =false;
		try{
			session = HibernateUtil.getSession();
			if(session!=null)
			transaction = session.beginTransaction();
			if(transaction!=null)
			{
				Employee employee = new Employee();
				employee.setEid(109);
				employee.setEname("Dhoni");
				employee.setEsalary(15000);
				session.save(employee);
				flag=true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(flag==true)
			{
				transaction.commit();
			}
			if(flag==false)
			{
				transaction.rollback();
			}
			
		}
	}

}
