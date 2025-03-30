package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class UpdateApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag =false;
		try{
			if(session!=null){
				Employee employee = session.get(Employee.class, 3);
				employee.setEname("Rayna");
				transaction = session.beginTransaction();
				session.update(employee);
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(flag){
				transaction.commit();
			}else{
				transaction.rollback();
			}
			
		}
	}
}
