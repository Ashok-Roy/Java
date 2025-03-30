package in.ineuron.main;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class PrimisticLockingThreadTwo {
	public static void main(String[] args) {
		Session session =null;
		Transaction transaction =null;
		boolean flag = false;
		try{
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class, 109, LockMode.UPGRADE_NOWAIT);
			employee.setEsalary(15000);
			session.save(employee);
			System.out.println("Thread one running....");
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(flag==true)
				transaction.commit();
			if(flag==false)
				transaction.rollback();
			
		}
		
		
		
	}

}
